package com.cartservice.dto;

import lombok.Data;

@Data
public class AddToCartRequest {
    private String grainName;
    private double price;
    private int quantity;

    // Constructors, getters, and setters
}
