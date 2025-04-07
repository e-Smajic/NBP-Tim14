package ba.unsa.etf.confix_be.core.security;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Custom principal object that contains the user's ID, email, company, and permissions.
 * This object is used to inject the user's information into the controller methods.
 * The permissions are stored in a {@link LinkedTreeMap} where the key is the company ID
 * and the value is a list of permissions for that company.
 * For example, if the user has the "create" and "list" permissions for the company with ID "org1",
 * the map would look like this:
 * <pre>
 *         {
 *         "org1": ["create", "list"]
 *         }
 *     </pre>
 * If the user has no permissions for a company, the map would look like this:
 * <pre>
 *         {
 *         "org1": []
 *         }
 *     </pre>
 * If the user has no permissions at all, the map would be empty.
 */
@Getter
@Setter
public class CustomPrincipal {
    private String email;

    private Long company;

    private Long userId;

    private LinkedTreeMap<String, List<String>> permissions;

    public CustomPrincipal(String email, Long orgId, LinkedTreeMap<String, List<String>> permissions, Long userId) {
        this.email = email;
        this.company = orgId;
        this.permissions = permissions;
        this.userId = userId;
    }
}
