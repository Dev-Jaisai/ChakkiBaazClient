package com.Catalog.Service.controller;
import com.Catalog.Service.dto.GrainDto;
import com.Catalog.Service.entity.Grain;
import com.Catalog.Service.service.CatalogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Catolog Rest api to interact with Grains Catalog",
        description = "Catolog Rest api to interact with Grains Catalog to add grains , get all grains information"
)

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @Operation(
            summary = "Create Grains REST API",
            description = "Create Grains REST API is used to save grains information in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/grains")
    public ResponseEntity<GrainDto> createGrain(@Valid @RequestBody GrainDto newGrain) {
        GrainDto grain = catalogService.createGrain(newGrain);
        return ResponseEntity.status(HttpStatus.CREATED).body(grain);
    }

    @Operation(
            summary = "Get Grain By ID REST API",
            description = "Get Grain By ID REST API is used to get a single grain from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )


    @GetMapping("/grains/{grainId}")
    public ResponseEntity<GrainDto> getGrainDetails(@PathVariable Long grainId) {
        GrainDto grain = catalogService.getGrainById(grainId);
        if (grain != null) {
            return ResponseEntity.ok(grain);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(
            summary = "Get All Grains REST API",
            description = "Get All Grains REST API is used to get a all the grains from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )


    @GetMapping("/grains")
    public ResponseEntity<List<GrainDto>> getAllGrains() {
        List<GrainDto> grains = catalogService.getAllGrains();
        return ResponseEntity.ok(grains);
    }
}
