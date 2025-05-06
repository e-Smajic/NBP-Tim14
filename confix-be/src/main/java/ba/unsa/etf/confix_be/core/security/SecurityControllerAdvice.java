package ba.unsa.etf.confix_be.core.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice(basePackages = "ba.unsa.etf.confix_be")
public class SecurityControllerAdvice {

    @ModelAttribute
    public CustomPrincipal customPrincipal(Authentication auth) {
        if (auth != null && auth.getPrincipal() instanceof Jwt jwt) {
            // 1) userId was stored under "uid"
            Number uidNum = jwt.getClaim("uid");
            Long userId = uidNum != null ? uidNum.longValue() : null;

            // 2) username is the JWT subject
            String username = jwt.getSubject();

            // 3) email claim
            String email = jwt.getClaimAsString("email");

            // 4) permissions map
            @SuppressWarnings("unchecked")
            Map<String, List<String>> perms = (Map<String, List<String>>) jwt.getClaim("permissions");

            return new CustomPrincipal(userId, username, email, perms);
        }
        return null;
    }
}
