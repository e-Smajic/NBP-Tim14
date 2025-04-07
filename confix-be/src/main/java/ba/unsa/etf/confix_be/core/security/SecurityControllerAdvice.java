package ba.unsa.etf.confix_be.core.security;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * Custom principal object that contains the user's email, company, and permissions.
 * This object is used to inject the user's information into the controller methods.
 */
@RestControllerAdvice(basePackages = {"ba.unsa.etf.confix_be"})
public class SecurityControllerAdvice {

    @ModelAttribute
    public CustomPrincipal customPrincipal(Authentication auth){
        if (auth != null && auth.getPrincipal() instanceof Jwt jwt) {
            String email = jwt.getClaimAsString("email");
            Long orgId = Long.valueOf(jwt.getClaimAsString("company"));
            Long id = Long.parseLong(jwt.getClaim("sub"));
            LinkedTreeMap<String, List<String>> permissions = jwt.getClaim("permissions");
            return new CustomPrincipal(email, orgId, permissions, id);
        }
        return null;
    }
}