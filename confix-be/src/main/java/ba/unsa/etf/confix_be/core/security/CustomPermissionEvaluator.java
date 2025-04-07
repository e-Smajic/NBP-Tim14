package ba.unsa.etf.confix_be.core.security;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import ba.unsa.etf.confix_be.core.exceptions.AuthorizationException;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication != null && authentication.getCredentials() instanceof Jwt jwt) {
            LinkedTreeMap<String, List<String>> permissions = jwt.getClaim("permissions");
            // TODO: We need to change this once OAuth2 is implemented. Currently, User Management adds permissions
            // to the JWT token in format bellow
            // {
            //   "permissions": {
            //     "1": ["permission1", "permission2"],
            //     "2": ["permission3", "permission4"]
            //   }
            // }
            if (permission != null && !permissions.get("1").contains((String) permission)) {
                throw new AuthorizationException();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
