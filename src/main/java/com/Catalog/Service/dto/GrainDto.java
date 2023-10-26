package com.Catalog.Service.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class GrainDto {
    private Long id;
    @Size(min=3 ,message = "Name should be greater0.")

    private String name;
    @Size(min = 3, message = "Description should have a minimum length of 3 characters")
    private String description;

    // Constructors, getters, and setters
}
