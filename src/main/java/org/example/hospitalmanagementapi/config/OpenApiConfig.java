package org.example.hospitalmanagementapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital Management API")
                        .description("Hospital Management API")
                        .version("1.0.0"));
    }
}
