package ba.unsa.etf.confix_be.core.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract base entity class with an auto-generated UUID as the identifier.
 *
 * <p>
 * This class extends {@link AbstractEntity} to inherit its base characteristics
 * and introduces an ID field that is automatically generated as a UUID.
 * Entities derived from this class will have a universally unique identifier
 * (UUID) as their primary key.
 * </p>
 *
 */
@Getter
@Setter
@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class AutoIdEntity extends AbstractEntity {
    /**
     * Unique identifier for the entity. Generated as a UUID.
     */
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
