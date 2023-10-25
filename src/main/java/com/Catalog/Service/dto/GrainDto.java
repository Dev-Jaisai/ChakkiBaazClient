package com.Catalog.Service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(
        description = "GrainsDto  Information"
)
@Data
public class GrainDto {
    private Long id;
    @Size(min=3 ,message = "Name should be greater0.")

    @Schema(description = "name of Grains")
    private String name;
    @Size(min = 3, message = "Description should have a minimum length of 3 characters")
    private String description;

    // Constructors, getters, and setters
}
