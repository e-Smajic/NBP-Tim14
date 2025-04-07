package ba.unsa.etf.confix_be.core.config;

/**
 * Auth configuration.
 */
public class Auth {

    /**
     * Get the user ID.
     *
     * @return the user ID
     */
    public static String getUserId() {
        return "temp";
    }

    /**
     * Get the user ID if it exists.
     *
     * @return the user ID
     */
    public static String getUserIdIfExists() {
        return getUserId();
    }
}
