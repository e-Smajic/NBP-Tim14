package ba.unsa.etf.confix_be.core.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PreRemove;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

/**
 * Abstract base entity class that includes auditing capabilities.
 *
 * <p>
 * This class extends {@link AbstractEntity} and provides fields and behavior
 * for tracking entity creation, modification, and deletion timestamps.
 * The use of {@link AuditingEntityListener} ensures that the created and
 * updated timestamps are automatically set during the JPA lifecycle.
 * </p>
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends AbstractEntity {

    /**
     * Timestamp indicating when the entity was created.
     * It's automatically set during entity creation.
     */
    @CreatedDate
    @Column(name = "created")
    private Instant created;

    /**
     * Timestamp indicating the last time the entity was modified.
     * It's automatically updated during entity modification.
     */
    @LastModifiedDate
    @Column(name = "updated")
    private Instant updated;

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
