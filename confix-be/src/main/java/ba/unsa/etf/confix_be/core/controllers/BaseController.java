package ba.unsa.etf.confix_be.core.controllers;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;
import ba.unsa.etf.confix_be.core.model.BaseSearchObject;
import ba.unsa.etf.confix_be.core.model.PagedResult;
import ba.unsa.etf.confix_be.core.model.SearchObjectAdditionalData;
import ba.unsa.etf.confix_be.core.security.CustomPrincipal;
import ba.unsa.etf.confix_be.core.services.BaseService;
import ba.unsa.etf.confix_be.core.shared.ListDeletedEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Generic controller interface providing base CRUD operations.
 *
 * <p>
 * This interface is equipped with default implementations for common operations like search and find by ID.
 * Entities and DTOs are parameterized to ensure flexibility across various domain-specific controllers.
 * </p>
 *
 * @param <E>    Entity type that extends {@link AbstractEntity}
 * @param <DTO>  Data Transfer Object type
 * @param <SObj> Search object type that extends {@link BaseSearchObject}
 * @param <T>    ID type
 */
@ControllerAdvice
public interface BaseController<E extends AbstractEntity, DTO, SObj extends BaseSearchObject, T> {

    /**
     * Fetch the service associated with this controller.
     *
     * @return the base service instance
     */
    BaseService<E, DTO, SObj, T> getService();

    /**
     * Searches for entities based on the given search object.
     *
     * @param cp        the custom principal
     * @param searchObj the search criteria
     * @return a paged result of matching DTOs
     */
    @GetMapping()
    default PagedResult<DTO> search(@RequestParam(required = false) ListDeletedEnum deleted, @Parameter(hidden = true) CustomPrincipal cp, @ParameterObject SObj searchObj) {
        if (deleted != null) {
            searchObj.setDeleted(deleted);
        }
        return getService().search(searchObj);
    }

    /**
     * Retrieves the DTO representation of an entity by its ID.
     *
     * @param cp             the custom principal
     * @param id             ID of the entity
     * @param additionalData additional search data
     * @return the corresponding DTO
     */
    @Transactional(readOnly = true)
    @GetMapping("{id}")
    @Operation(operationId = "find#ById", parameters = {@Parameter(in = ParameterIn.PATH, name = "#")})
    default DTO findById(@RequestParam(required = false) ListDeletedEnum deleted,
                         @Parameter(hidden = true) CustomPrincipal cp,
                         @PathVariable T id,
                         @ParameterObject SearchObjectAdditionalData additionalData) {
        if (deleted != null) {
            additionalData.setDeleted(deleted);
        }
        return getService().findById(id, additionalData);
    }

    /**
     * Used to check if the user has the permission to list entities
     * If null, no permission is required
     *
     * @return the permission required to list entities
     */
    default String getListPermission() {
        return null;
    }

    /**
     * Used to check if the user has the permission to read entities
     * If null, no permission is required
     *
     * @return the permission required to read entities
     */
    default String getReadPermission() {
        return null;
    }
}
