package ba.unsa.etf.confix_be.core.security;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Custom principal object that contains the user's ID, email, company, and
 * permissions.
 * This object is used to inject the user's information into the controller
 * methods.
 * The permissions are stored in a {@link LinkedTreeMap} where the key is the
 * company ID
 * and the value is a list of permissions for that company.
 * For example, if the user has the "create" and "list" permissions for the
 * company with ID "org1",
 * the map would look like this:
 * 
 * <pre>
 *         {
 *         "org1": ["create", "list"]
 *         }
 * </pre>
 * 
 * If the user has no permissions for a company, the map would look like this:
 * 
 * <pre>
 *         {
 *         "org1": []
 *         }
 * </pre>
 * 
 * If the user has no permissions at all, the map would be empty.
 */
public record CustomPrincipal(
        Long userId,
        String username,
        String email,
        Map<String, List<String>> permissions) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
