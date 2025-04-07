package ba.unsa.etf.confix_be.core.mappers;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import org.mapstruct.MappingTarget;

/**
 * Base interface for entity-DTO mappers with CRUD operations.
 *
 * <p>
 * Extends the {@link BaseMapper} interface to provide additional utility methods
 * specifically for Create and Update operations. This interface establishes a
 * standard for converting insert and update request objects to entity objects,
 * ensuring consistent mapping behavior across the system.
 * </p>
 *
 * @param <E>            the type of entity derived from AbstractEntity
 * @param <DTO>          the type of DTO (Data Transfer Object) to map to/from
 * @param <InsertRequest> the type of insert request object used in Create operations
 * @param <UpdateRequest> the type of update request object used in Update operations
 **/
public interface BaseCRUDMapper<E extends AbstractEntity, DTO, InsertRequest, UpdateRequest> extends BaseMapper<E, DTO> {

    /**
     * Maps an insert request to an entity object.
     *
     * @param request the insert request object to map
     * @return the corresponding entity
     */
    E toEntityFromInsert(InsertRequest request);

    /**
     * Updates an entity object based on the data in an update request.
     *
     * <p>
     * This method doesn't return a value, but instead modifies the target entity
     * provided as a parameter based on the update request's content.
     * </p>
     *
     * @param request the update request object containing the new data
     * @param entity  the target entity to update
     */
    void toEntityFromUpdate(UpdateRequest request, @MappingTarget E entity);
}
