package ba.unsa.etf.confix_be.core.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract base entity class with auto-generated UUID, code, value, and an active status.
 *
 * <p>
 * Extends {@link AbstractEntity} to inherit base characteristics and adds an ID field that
 * is automatically generated as a UUID. Entities derived from this class will have
 * a universally unique identifier (UUID) as their primary key, in addition to a
 * code, value, and a status indicating whether they are active.
 * </p>
 *
 */
@Getter
@Setter
@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class AutoIdCodeEntity extends AbstractEntity {

    /**
     * Unique identifier for the entity. Generated as a UUID.
     */
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Code associated with the entity.
     */
    @Column(name = "code")
    private String code;

    /**
     * Value corresponding to the entity's code.
     */
    @Column(name = "value")
    private String value;

    /**
     * Indicator specifying whether the entity is currently active.
     */
    @Column(name = "isActive")
    private Boolean isActive;
}
