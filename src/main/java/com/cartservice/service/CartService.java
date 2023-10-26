package com.cartservice.service;

import com.cartservice.entity.CartItem;

import java.util.Map;

public interface CartService {
    void addToCart(String grainName, int quantity, double price);

    Map<String, CartItem> getCartItems();
    // Add other cart-related methods if needed
}
