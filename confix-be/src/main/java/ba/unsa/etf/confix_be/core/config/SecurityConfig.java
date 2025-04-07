package ba.unsa.etf.confix_be.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.List;

/**
 * Security configuration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * List of endpoints that are permitted without authentication.
     */
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
            // other public endpoints of your API may be appended to this array
    };
    /**
     * Secret key used to encode and decode JWT.
     */
    @Value("${secretKey}")
    private String secretKey;

    @Value("${cors.allowed-origins}")
    private String[] allowedOrigins;

    @Value("${cors.allowed-headers}")
    private String[] allowedHeaders;

    @Value("${cors.allowed-methods}")
    private String[] allowedMethods;

    /**
     * Configure security, allow white listed endpoints and require authentication for the rest.
     *
     * @param http security
     * @return security filter chain
     * @throws Exception exception
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                );

        return http.build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        // CORS configuration
        // TODO: Update allowed origins, methods, headers, and max age -
        //  take value from application.properties (nest sprint)
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of(allowedOrigins));
        corsConfiguration.setAllowedMethods(List.of(allowedMethods));
        //corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of(allowedHeaders));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    /**
     * JWT decoder, used to decode JWT with HS256 signature algorithm.
     *
     * @return JWT decoder
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey secretKeyObj = new SecretKeySpec(this.secretKey.getBytes(), "HMACSHA256");
        // JWT with HS256 signature algorithm
        JwtDecoder jwtDecoder = NimbusJwtDecoder.withSecretKey(secretKeyObj)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
        return new JwtDecoder() {
            @Override
            public Jwt decode(String token) {
                return jwtDecoder.decode(token);
            }
        };
    }
}