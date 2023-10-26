package com.Catalog.Service.controller;

import com.Catalog.Service.dto.AddToCartRequest;
import com.Catalog.Service.dto.GrainDto;
import com.Catalog.Service.feign.CartServiceFeignClient;

import com.Catalog.Service.service.CatalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final CartServiceFeignClient cartServiceFeignClient;
    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService, CartServiceFeignClient cartServiceFeignClient) {
        this.catalogService = catalogService;
        this.cartServiceFeignClient = cartServiceFeignClient;
    }

    @PostMapping("/grains")
    public ResponseEntity<GrainDto> createGrain(@Valid @RequestBody GrainDto newGrain) {
        GrainDto grain = catalogService.createGrain(newGrain);
        return ResponseEntity.status(HttpStatus.CREATED).body(grain);
    }



    @GetMapping("/grains/{grainId}")
    public ResponseEntity<GrainDto> getGrainDetails(@PathVariable Long grainId) {
        GrainDto grain = catalogService.getGrainById(grainId);
        if (grain != null) {
            return ResponseEntity.ok(grain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @GetMapping("/grains")
    public ResponseEntity<List<GrainDto>> getAllGrains() {
        List<GrainDto> grains = catalogService.getAllGrains();
        return ResponseEntity.ok(grains);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCArt(@RequestBody AddToCartRequest addToCartRequest) {

        ResponseEntity<String> response = cartServiceFeignClient.addToCart(addToCartRequest);

        return response;
    }
}
