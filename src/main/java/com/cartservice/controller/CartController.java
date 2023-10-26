package com.cartservice.controller;


import com.cartservice.dto.AddToCartRequest;
import com.cartservice.entity.CartItem;
import com.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        cartService.addToCart(addToCartRequest.getGrainName(), addToCartRequest.getQuantity(), addToCartRequest.getPrice());
        return ResponseEntity.ok("Item added to the cart.");
    }

    @GetMapping("/items")
    public ResponseEntity<Map<String, CartItem>> getCartItems() {
        Map<String, CartItem> cartItems = cartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }}

