package com.Catalog.Service.feign;

import com.Catalog.Service.dto.AddToCartRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cart-service")
public interface CartServiceFeignClient {

    @PostMapping("/cart/addToCart")
    ResponseEntity<String> addToCart(@RequestBody AddToCartRequest addToCartRequest);
}
