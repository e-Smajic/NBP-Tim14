package ba.unsa.etf.confix_be.core.services;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import ba.unsa.etf.confix_be.core.entities.BaseEntity;
import ba.unsa.etf.confix_be.core.exceptions.NotFoundException;
import ba.unsa.etf.confix_be.core.localization.MessageUtil;
import ba.unsa.etf.confix_be.core.mappers.BaseMapper;
import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import ba.unsa.etf.confix_be.core.model.PagedResult;
import ba.unsa.etf.confix_be.core.model.SearchObjectAdditionalData;
import ba.unsa.etf.confix_be.core.shared.ListDeletedEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.*;
import java.util.stream.StreamSupport;

import static java.lang.String.join;

/**
 * Base interface for the service layer providing common CRUD and search operations.
 *
 * @param <E>       Entity type derived from AbstractEntity.
 * @param <DTO>     DTO (Data Transfer Object) type.
 * @param <SObject> Search object type.
 * @param <T>       ID type.
 */
public interface BaseService<E extends AbstractEntity, DTO, SObject extends BaseSearchObject, T> {

    /**
     * @return Repository for the service.
     */
    CrudRepository<E, T> getRepository();

    /**
     * @return Entity manager for the service.
     */
    EntityManager getEntityManager();

    /**
     * @return Mapper responsible for converting between entity and DTO.
     */
    BaseMapper<E, DTO> getMapper();

    /**
     * @return Class type of the entity.
     */
    Class<E> getEntityClass();

    /**
     * Fetch all entities.
     *
     * @return List of entities.
     */
    default List<E> findAll() {
        return StreamSupport.stream(getRepository().findAll().spliterator(), false).toList();
    }

    /**
     * Fetch all entities and map them to DTOs.
     *
     * @return List of DTOs.
     */
    default List<DTO> findAllDtos() {
        return getMapper().toDtoList(findAll());
    }

    /**
     * Find an entity by its ID, optionally with more details.
     *
     * @param id     Entity's ID.
     * @param search Additional search parameters.
     * @return Entity or null.
     */
    default E findByIdInternal(T id, SearchObjectAdditionalData search) {
        if (search == null) {
            return findEntityById(id, new SearchObjectAdditionalData());
        } else if (search.getIncludePath() == null) {
            return findEntityById(id, search);
        } else {
            return findByIdInternalWithInclude(id, search);
        }
    }

    /**
     * Find an entity by its ID with additional details.
     *
     * @param id     Entity's ID.
     * @param search Additional search parameters.
     * @return Entity or null.
     */
    private E findByIdInternalWithInclude(T id, SearchObjectAdditionalData search) {
        var searchObject = new BaseSearchObject();
        searchObject.setId(id);
        searchObject.setIncludePath(search.getIncludePath());

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(getEntityClass());
        Root<E> root = query.from(getEntityClass());
        Map<String, Join> relatedJoins = new HashMap<>();
        includeInSelect(searchObject, relatedJoins, root);
        var filters = new ArrayList<Predicate>();
        filters.add(builder.equal(root.get("id"), id));

        if (search.getDeleted() == ListDeletedEnum.DELETED) {
            filters.add(builder.isNotNull(root.get("deletedAt")));
        } else if (search.getDeleted() == ListDeletedEnum.NOT_DELETED) {
            filters.add(builder.isNull(root.get("deletedAt")));
        }

        query.where(builder.and(filters.toArray(new Predicate[0])));
        TypedQuery<E> typedQuery = getEntityManager().createQuery(query);
        var result = typedQuery.getResultList().stream().findFirst();
        return result.orElse(null);
    }

    /**
     * Find an DTO by its ID, optionally with more details.
     *
     * @param id     Entity's ID.
     * @param search Additional search parameters.
     * @return Entity or null.
     */
    default DTO findById(T id, SearchObjectAdditionalData search) {
        var entity = findByIdInternal(id, search);

        return getMapper().toDto(entity);
    }

    /**
     * Find an entity by its ID.
     *
     * @param id Entity's ID.
     * @return Entity or null.
     */
    private E findEntityById(T id, SearchObjectAdditionalData search) {
        E entity = getRepository().findById(id).orElse(null);
        if(entity instanceof BaseEntity baseEntity) {
            if (search.getDeleted() == ListDeletedEnum.DELETED && baseEntity.getDeletedAt() != null) {
                return null;
            } else if (search.getDeleted() == ListDeletedEnum.NOT_DELETED && baseEntity.getDeletedAt() == null) {
                return null;
            }
        }

        return entity;
    }

    /**
     * Search for entities.
     *
     * @param searchObj Search object.
     * @return Paged result.
     */
    default Page<E> searchInternal(SObject searchObj) {
        var limit = searchObj.getLimit() == null || searchObj.getLimit() <= 0 ? 10 : searchObj.getLimit();
        if (searchObj.getGetAll() != null && searchObj.getGetAll()) {
            limit = 10000;
        }
        var page = searchObj.getPage() != null ? searchObj.getPage() : 0;

        var pageable = Pageable.ofSize(limit).withPage(page);

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<E> query = builder.createQuery(getEntityClass());
        Root<E> root = query.from(getEntityClass());

        Map<String, Join> relatedJoins = new HashMap<>();

        includeInSelect(searchObj, relatedJoins, root);
        includeOrderByIfNeeded(searchObj, builder, query, root, relatedJoins);

        var filter = new ArrayList<Predicate>();
        var additionalFilter = additionalFilter(builder, searchObj, root, relatedJoins);

        if (additionalFilter != null) {
            filter.addAll(additionalFilter);
        }

        query.where(builder.and(filter.toArray(new Predicate[0])));

        TypedQuery<E> typedQuery = getEntityManager().createQuery(query);

        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        return PageableExecutionUtils.getPage(typedQuery.getResultList(), pageable, () -> {
            CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
            Root<E> countRoot = countQuery.from(getEntityClass());
            countQuery.select(builder.count(countRoot));

            var filter2 = new ArrayList<Predicate>();
            var additionalFilter2 = additionalFilter(builder, searchObj, countRoot, new HashMap<>());

            if (additionalFilter2 != null) {
                filter2.addAll(additionalFilter2);
            }

            countQuery.where(builder.and(filter2.toArray(new Predicate[0])));
            Long count = 100L;

            if (searchObj.getIncludeCount() != null) {
                count = getEntityManager().createQuery(countQuery).getSingleResult();
            }
            //
            return count;
        });
    }

    /**
     * Search for entities.
     *
     * @param searchObj Search object.
     * @return Paged result.
     */
    default PagedResult<E> searchEntities(SObject searchObj) {
        var internalResult = searchInternal(searchObj);
        PagedResult<E> result = new PagedResult<>();
        result.resultList = internalResult.toList();
        result.hasMore = result.resultList.size() >= searchObj.getLimit();
        result.count = internalResult.getTotalElements();
        return result;
    }

    /**
     * Search for entities and map them to DTOs.
     *
     * @param searchObj Search object.
     * @return Paged result.
     */
    default PagedResult<DTO> search(SObject searchObj) {
        var internalResult = searchInternal(searchObj);
        PagedResult<DTO> result = new PagedResult<>();
        result.resultList = getMapper().toDtoList(internalResult.toList());
        result.hasMore = result.resultList.size() >= searchObj.getLimit();
        result.count = internalResult.getTotalElements();
        return result;
    }

    /**
     * Add order by to the query if needed.
     *
     * @param searchObj    Search object.
     * @param builder      Criteria builder.
     * @param query        Criteria query.
     * @param root         Root.
     * @param relatedJoins Related joins.
     */
    private void includeOrderByIfNeeded(BaseSearchObject searchObj, CriteriaBuilder builder, CriteriaQuery<E> query, Root<E> root, Map<String, Join> relatedJoins) {
        if (searchObj.getOrder() != null) {
            var parts = searchObj.getOrder().split("&");
            for (var part :
                    parts) {
                var fieldAndDirection = part.split(":");
                var field = fieldAndDirection[0];
                var dir = fieldAndDirection[1];
                var fieldNameOnly = field.substring(field.lastIndexOf('.') == -1 ? 0 : field.lastIndexOf('.') + 1);

                if (field.contains(".")) {
                    var tableName = field.substring(0, field.lastIndexOf('.'));
                    var join = getJoin(tableName, false, root, relatedJoins);
                    if (dir.equals("a")) {
                        query.orderBy(builder.asc(join.get(fieldNameOnly)));
                    } else {
                        query.orderBy(builder.desc(join.get(fieldNameOnly)));
                    }
                } else {
                    if (dir.equals("a")) {
                        query.orderBy(builder.asc(root.get(fieldNameOnly)));
                    } else {
                        query.orderBy(builder.desc(root.get(fieldNameOnly)));
                    }
                }
            }
        }
    }

    /**
     * Include joins in the select query.
     *
     * @param searchObj    Search object.
     * @param relatedJoins Related joins.
     * @param root         Root.
     */
    default void includeInSelect(BaseSearchObject searchObj, Map<String, Join> relatedJoins, Root<E> root) {
        if (searchObj != null && searchObj.getIncludePath() != null) {
            var includes = searchObj.getIncludePath().split(",");
            for (var include :
                    includes) {
                getJoin(include.trim(), true, root, relatedJoins);
            }
        }
    }

    /**
     * Get join.
     *
     * @param field   Field.
     * @param isFetch Is fetch.
     * @param root    Root.
     * @param joins   Joins.
     * @return Join.
     */
    default Join getJoin(String field, Boolean isFetch, Root<E> root, Map<String, Join> joins) {
        var associations = field.split("\\.");
        Join path = null;

        var associationPath = "";
        for (var association : associations) {
            associationPath = associationPath.isEmpty() ? association : associationPath + "." + association;
            if (joins.containsKey(associationPath)) {
                path = joins.get(associationPath);
            } else {
                if (path == null) {
                    if (isFetch) {
                        path = (Join) root.fetch(association, JoinType.LEFT);
                    } else {
                        path = root.join(association, JoinType.LEFT);
                    }

                } else {
                    if (isFetch) {
                        path = (Join) path.fetch(association, JoinType.LEFT);
                    } else {
                        path = path.join(association, JoinType.LEFT);
                    }
                }
                joins.put(associationPath, path);
            }
        }

        return path;
    }

    /**
     * Add additional filter.
     *
     * @param builder      Criteria builder.
     * @param searchObject Search object.
     * @param root         Root.
     * @param relatedJoins Related joins.
     * @return List of predicates.
     */
    default List<Predicate> additionalFilter(CriteriaBuilder builder, SObject searchObject, Root<E> root, Map<String, Join> relatedJoins) {
        //NOTE this method adds custom queries based on search object in service
        List<Predicate> filters = new ArrayList<>();
        if (searchObject.getDeleted() == ListDeletedEnum.DELETED) {
            filters.add(builder.isNotNull(root.get("deletedAt")));
        } else if (searchObject.getDeleted() == ListDeletedEnum.NOT_DELETED) {
            filters.add(builder.isNull(root.get("deletedAt")));
        }
        return filters;
    }

    /**
     * Not found exception.
     *
     * @param params Params.
     * @return Not found exception.
     */
    default NotFoundException notFoundException(Object... params) {
        var name = this.getClass().getSimpleName();
        var data = Arrays.stream(params == null ? new String[0] : params).map(Object::toString).toList();
        return new NotFoundException(MessageUtil.getMessage("error.resource_not_found", name, join(", ", data)));
    }

}
