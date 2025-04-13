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
 * Abstract base entity class with auto-generated UUID as the identifier.
 *
 * <p>
 * Extends {@link BaseEntity} to inherit base characteristics and adds an ID field that
 * is automatically generated as a UUID. Entities derived from this class will have
 * a universally unique identifier (UUID) as their primary key.
 * </p>
 *
 */

@MappedSuperclass
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class AutoIdBaseEntity extends BaseEntity {

    /**
     * Unique identifier for the entity. Generated as a UUID.
     */
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
