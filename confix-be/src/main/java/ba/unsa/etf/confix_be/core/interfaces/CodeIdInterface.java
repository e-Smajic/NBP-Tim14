package ba.unsa.etf.confix_be.core.interfaces;

/**
 * Interface for entities that have a code and an ID.
 *
 * <p>
 * This interface is used to provide a common interface for entities that have
 * a code and an ID. This is useful for entities that are used as reference data
 * in the system.
 * </p>
 */
public interface CodeIdInterface {
    /**
     * Returns the code of the entity.
     *
     * @return the code of the entity
     */
    String getCode();

    /**
     * Returns the ID of the entity.
     *
     * @return the ID of the entity
     */
    Long getId();
}
