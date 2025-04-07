package ba.unsa.etf.confix_be.core.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Open API configuration.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Custom API.
     *
     * @return custom API
     */
    @Bean
    public OpenAPI customApi() {
        var securitySchemeName = "bearerAuth";
        var bearerSchema = new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .scheme("bearer").bearerFormat("JWT");
        var component = new Components()
                .addSecuritySchemes(securitySchemeName, bearerSchema);
        return new OpenAPI()
                .components(component)
                .security(List.of(new SecurityRequirement().addList(securitySchemeName)))
                .info(new Info().title("Depot Management Backend").version("v1"));
    }

    @Bean
    OpenApiCustomizer operationIdCustomNames() {
        return openApi -> {
            var values = openApi.getPaths().values();
            values.stream().flatMap(pathItem -> pathItem.readOperations().stream()).forEach(this::customOperation);
        };
    }

    private void customOperation(Operation operation) {
        operation.setSummary(getSummary(operation.getTags(), operation.getSummary()));
    }

    private String getSummary(List<String> tags, String summary) {
        var first = tags.stream().filter(tag -> tag.equals("public"));
        //  @Tag(name = "public")
        if (first.findFirst().isPresent()) {
            return "Bearer token is not required for this endpoint";
        }
        return "Bearer token is required for this endpoint.";
    }
}
