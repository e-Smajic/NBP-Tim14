package ba.unsa.etf.confix_be.core.services;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import ba.unsa.etf.confix_be.core.mappers.BaseCRUDMapper;
import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import ba.unsa.etf.confix_be.core.model.SearchObjectAdditionalData;

import java.util.ArrayList;

/**
 * Base CRUD service
 *
 * @param <E>       Entity
 * @param <DTO>     DTO
 * @param <SObject> Search object
 * @param <TInsert> Insert request
 * @param <TUpdate> Update request\
 * @param <T>       Id type
 */
public interface BaseCRUDService<E extends AbstractEntity, DTO, SObject extends BaseSearchObject, TInsert, TUpdate, T> extends BaseService<E, DTO, SObject, T> {
    BaseCRUDMapper<E, DTO, TInsert, TUpdate> getMapper();

    /**
     * Insert new entity
     *
     * @param request Insert request
     * @return DTO
     */
    default DTO insert(TInsert request) {
        var entity = getMapper().toEntityFromInsert(request);
        beforeInsert(request, entity);
        getRepository().save(entity);
        afterInsert(request, entity);
        return getMapper().toDto(entity);
    }

    /**
     * Remove entity
     *
     * @param id      Entity id
     * @return DTO
     */
    default DTO remove(T id, SearchObjectAdditionalData searchObjectAdditionalData) {
        var entity = findByIdInternal(id, searchObjectAdditionalData);
        getRepository().delete(entity);
        return getMapper().toDto(entity);
    }

    /**
     * Update entity
     *
     * @param id      Entity id
     * @param request Update request
     * @return DTO
     */
    default DTO update(T id, TUpdate request, SearchObjectAdditionalData searchObjectAdditionalData) {
        var entity = findByIdInternal(id, searchObjectAdditionalData);
        beforeUpdate(request, entity);
        getMapper().toEntityFromUpdate(request, entity);
        getRepository().save(entity);
        afterUpdate(request, entity);
        return getMapper().toDto(entity);
    }

    /**
     * Save entity
     *
     * @param entity Entity
     * @return DTO
     */
    default DTO saveEntity(E entity) {
        getRepository().save(entity);
        return getMapper().toDto(entity);
    }

    default E saveEntityInternal(E entity) {
        getRepository().save(entity);
        return entity;
    }

    default void saveEntities(ArrayList<E> entities) {
        getRepository().saveAll(entities);
    }

    /**
     * beforeInsert
     *
     * @param request Insert request
     * @param entity  Entity
     */
    default void beforeInsert(TInsert request, E entity) {

    }

    /**
     * beforeUpdate
     *
     * @param request Update request
     * @param entity  Entity
     */
    default void beforeUpdate(TUpdate request, E entity) {

    }

    /**
     * afterInsert
     *
     * @param request Insert request
     * @param entity  Entity
     */
    default void afterInsert(TInsert request, E entity) {

    }

    /**
     * afterUpdate
     *
     * @param request Update request
     * @param entity  Entity
     */
    default void afterUpdate(TUpdate request, E entity) {

    }
}
