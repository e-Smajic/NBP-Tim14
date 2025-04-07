package ba.unsa.etf.confix_be.core.controllers;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import ba.unsa.etf.confix_be.core.model.SearchObjectAdditionalData;
import ba.unsa.etf.confix_be.core.security.CustomPrincipal;
import ba.unsa.etf.confix_be.core.services.BaseCRUDService;
import ba.unsa.etf.confix_be.core.shared.ListDeletedEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Generic controller interface providing base CRUD (Create, Read, Update, Delete) operations.
 *
 * <p>
 * This interface extends the basic operations from {@link BaseController} and includes additional
 * methods for creating and updating entities. Entities, DTOs, and request objects are parameterized
 * to ensure flexibility across various domain-specific controllers.
 * </p>
 *
 * @param <E>       Entity type that extends {@link AbstractEntity}
 * @param <DTO>     Data Transfer Object type
 * @param <SObj>    Search object type that extends {@link BaseSearchObject}
 * @param <TInsert> Object type used for entity insertion
 * @param <TUpdate> Object type used for entity updates
 * @param <T>       ID type
 */
public interface BaseCRUDController<E extends AbstractEntity, DTO, SObj extends BaseSearchObject, TInsert, TUpdate, T> extends BaseController<E, DTO, SObj, T> {

    /**
     * Fetch the CRUD service associated with this controller.
     *
     * @return the base CRUD service instance
     */
    BaseCRUDService<E, DTO, SObj, TInsert, TUpdate, T> getService();

    /**
     * Creates a new entity based on the provided payload.
     *
     * @param cp      the custom principal
     * @param payload the object containing details for creation
     * @return the DTO representation of the created entity
     */
    @PostMapping()
    @Transactional()
    @Operation(operationId = "create#", parameters = {@Parameter(in = ParameterIn.PATH, name = "#")})
    default DTO create(@Parameter(hidden = true) CustomPrincipal cp, @Validated @RequestBody TInsert payload) {
        return getService().insert(payload);
    }

    /**
     * Updates an existing entity based on the provided payload and ID.
     *
     * @param cp      the custom principal
     * @param id      ID of the entity to be updated
     * @param payload the object containing details for updating the entity
     * @return the DTO representation of the updated entity
     */
    @Transactional()
    @PutMapping("{id}")
    @Operation(operationId = "update#ById", parameters = {@Parameter(in = ParameterIn.PATH, name = "#")})
    default DTO update(@Parameter(hidden = true) CustomPrincipal cp,
                       @PathVariable T id,
                       @ParameterObject SearchObjectAdditionalData additionalData,
                       @RequestParam(required = false) ListDeletedEnum deleted,
                       @Validated @RequestBody TUpdate payload) {
        if (deleted != null) {
            additionalData.setDeleted(deleted);
        }
        return getService().update(id, payload, additionalData);
    }

    /**
     * Deletes an existing entity based on the provided payload and ID.
     *
     * @param cp      the custom principal
     * @param id      ID of the entity to be deleted
     * @return the DTO representation of the deleted entity
     */
    @Transactional()
    @DeleteMapping("{id}")
    @Operation(operationId = "delete#ById", parameters = {@Parameter(in = ParameterIn.PATH, name = "#")})
    default DTO remove(@Parameter(hidden = true) CustomPrincipal cp,
                       @PathVariable T id,
                       @ParameterObject SearchObjectAdditionalData additionalData,
                       @RequestParam(required = false) ListDeletedEnum deleted
    ) {
        if (deleted != null) {
            additionalData.setDeleted(deleted);
        }
        return getService().remove(id, additionalData);
    }

    /**
     * Used to check if the user has the permission to create entities
     * If null, no permission is required
     *
     * @return the permission required to create entities
     */
    default String getCreatePermission() {
        return null;
    }

    /**
     * Used to check if the user has the permission to update entities
     * If null, no permission is required
     *
     * @return the permission required to update entities
     */
    default String getUpdatePermission() {
        return null;
    }
}
