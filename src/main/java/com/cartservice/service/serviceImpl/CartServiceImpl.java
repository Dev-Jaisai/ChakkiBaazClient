package com.cartservice.service.serviceImpl;

import com.cartservice.entity.CartItem;
import com.cartservice.service.CartService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartServiceImpl implements CartService {

    // Use an in-memory data structure to store cart items for the session
    private Map<String, CartItem> cartItems = new HashMap<>();

    @Override
    public void addToCart(String grainName, int quantity, double price) {
        CartItem cartItem = cartItems.get(grainName);

        if (cartItem != null) {
            // Update the existing cart item
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            // Create a new cart item
            CartItem newItem = new CartItem();
            newItem.setGrainName(grainName);
            newItem.setQuantity(quantity);
            newItem.setPrice(price);
            cartItems.put(grainName, newItem);
        }
    }

    // Add other cart-related methods here

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }
}
