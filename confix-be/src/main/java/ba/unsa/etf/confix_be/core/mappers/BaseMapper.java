package ba.unsa.etf.confix_be.core.mappers;

import ba.unsa.etf.confix_be.core.entities.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Base interface for entity to DTO mappers.
 *
 * <p>
 * Provides utility methods for transforming entities to their respective DTOs
 * and vice versa. It serves as a blueprint for other specific entity-DTO mappers
 * in the system, ensuring a consistent approach to transformation logic.
 * </p>
 *
 * @param <E>   the type of entity derived from AbstractEntity
 * @param <DTO> the type of DTO (Data Transfer Object) to map to/from
 */
public interface BaseMapper<E extends AbstractEntity, DTO> {

    /**
     * Maps a single entity to its corresponding DTO.
     *
     * @param entity the entity to map
     * @return the corresponding DTO
     */
    DTO toDto(E entity);

    /**
     * Maps a list of entities to a list of their corresponding DTOs.
     *
     * @param entities the list of entities to map
     * @return a list of corresponding DTOs
     */
    default List<DTO> toDtoList(List<E> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }
        return entities.stream().map(this::toDto).collect(toList());
    }
}
