package com.Catalog.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequest {

    private String grainName;
    private double price;
    private int quantity;

    // Constructors, getters, and setters
}
