package ba.unsa.etf.confix_be.core.interfaces;

/**
 * Interface for entities that have a value and an ID.
 *
 * <p>
 * This interface is used to provide a common interface for entities that have
 * a value and an ID. This is useful for entities that are used as reference data
 * in the system.
 * </p>
 */
public interface ValueIdInterface {
    /**
     * Returns the value of the entity.
     *
     * @return the value of the entity
     */
    String getValue();

    /**
     * Returns the ID of the entity.
     *
     * @return the ID of the entity
     */
    Long getId();
}
