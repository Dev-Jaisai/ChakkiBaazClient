package com.Catalog.Service.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ChakkiBaaz Grains",
                description = "Spring Boot REST API Documentation For Inserting Grains ",
                version = "v1.0",
                contact = @Contact(
                        name = "Jaisai Sarkate",
                        email = "jaisaisarkate0506@gmail.com"

                )

        )
)
public class Swagger {
}
