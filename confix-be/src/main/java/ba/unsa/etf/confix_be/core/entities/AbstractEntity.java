package ba.unsa.etf.confix_be.core.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract base entity class for all entity types.
 *
 * <p>
 * This class serves as the foundation for all other entity classes in the system.
 * </p>
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

}
