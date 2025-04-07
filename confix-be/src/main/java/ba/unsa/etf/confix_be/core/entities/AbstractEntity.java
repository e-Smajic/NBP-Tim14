package ba.unsa.etf.confix_be.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreRemove;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * Abstract base entity class for all entity types.
 *
 * <p>
 * This class serves as the foundation for all other entity classes in the system.
 * Entities derived from this class will inherit common attributes and behaviors,
 * as well as auditing capabilities provided by {@link AuditingEntityListener}.
 * </p>
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity {
    /**
     * Timestamp indicating when the entity was marked as deleted.
     * It's set when an entity is removed without being physically
     * deleted from the database.
     */
    @Column(name = "deleted")
    private Instant deletedAt;

    /**
     * Lifecycle callback to mark an entity as deleted.
     * The {@link #deletedAt} timestamp is set with the current time
     * when an entity is about to be removed.
     */
    @PreRemove
    private void preRemove() {
        this.deletedAt = Instant.now();
    }
}
