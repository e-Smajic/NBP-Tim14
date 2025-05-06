package ba.unsa.etf.confix_be.core.config;

import ba.unsa.etf.confix_be.core.security.CustomPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

  private static final String[] AUTH_WHITELIST = {
      // -- Swagger UI v2
      "/v2/api-docs",
      "/swagger-resources",
      "/swagger-resources/**",
      "/configuration/ui",
      "/configuration/security",
      "/swagger-ui.html",
      "/webjars/**",
      // -- Swagger UI v3 (OpenAPI)
      "/v3/api-docs/**",
      "/swagger-ui/**",
      "/public/**",
      "/api-docs/**",
      "/uploads/**",
      "/tracking-link/**",
      "/api/auth/login",
      "/api/auth/register",
      "/api/auth/forgot-password", "/api/auth/reset-password"
  };

  @Value("${secretKey}")
  private String secret;
  @Value("${cors.allowed-origins}")
  private String[] allowedOrigins;
  @Value("${cors.allowed-headers}")
  private String[] allowedHeaders;
  @Value("${cors.allowed-methods}")
  private String[] allowedMethods;

  /* ────────── TOKEN VALIDATION ────────── */

  @Bean
  JwtDecoder jwtDecoder() {
    SecretKey key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA512");
    return NimbusJwtDecoder
        .withSecretKey(key)
        .macAlgorithm(MacAlgorithm.HS512)
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  }

  @Bean
  public BearerTokenResolver bearerTokenResolver() {
    return new CookieBearerTokenResolver();
  }

  /**
   * Converts a raw Jwt into an Authentication whose principal is our
   * CustomPrincipal.
   */
  private Converter<Jwt, ? extends AbstractAuthenticationToken> customJwtAuthConverter() {
    return jwt -> {
      @SuppressWarnings("unchecked")
      Map<String, List<String>> perms = (Map<String, List<String>>) jwt.getClaim("permissions");

      var authz = perms.values().stream()
          .flatMap(Collection::stream)
          .map(p -> new SimpleGrantedAuthority("PERM_" + p.toUpperCase()))
          .collect(Collectors.toSet());

      Long uid = ((Number) jwt.getClaim("uid")).longValue();
      String user = jwt.getSubject();
      String email = jwt.getClaimAsString("email");
      CustomPrincipal principal = new CustomPrincipal(uid, user, email, perms);

      return new UsernamePasswordAuthenticationToken(principal, jwt, authz);
    };
  }

  /* ────────── HTTP SECURITY ────────── */

  @Bean
  SecurityFilterChain api(HttpSecurity http) throws Exception {
    http
        .cors(c -> c.configurationSource(cors()))
        .csrf(csrf -> csrf.disable())
        .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/login", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
            .requestMatchers(AUTH_WHITELIST).permitAll()
            .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2
            .bearerTokenResolver(bearerTokenResolver())
            .jwt(jwt -> jwt.jwtAuthenticationConverter(customJwtAuthConverter())));
    return http.build();
  }

  @Bean
  AuthenticationManager authenticationManager(AuthenticationConfiguration cfg) throws Exception {
    return cfg.getAuthenticationManager();
  }

  /* ── CORS ────────────────────────────────────────── */
  @Bean
  CorsConfigurationSource cors() {
    CorsConfiguration cfg = new CorsConfiguration();

    cfg.addAllowedOriginPattern("*");
    cfg.setAllowCredentials(true);

    cfg.addAllowedHeader("*");
    cfg.addAllowedMethod("*");
    cfg.setMaxAge(3600L);

    UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
    src.registerCorsConfiguration("/**", cfg);
    return src;
  }

}
