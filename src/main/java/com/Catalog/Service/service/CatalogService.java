package com.Catalog.Service.service;

import com.Catalog.Service.dto.GrainDto;
import com.Catalog.Service.entity.Grain;

import java.util.List;

public interface CatalogService {


    GrainDto createGrain(GrainDto newGrain);

    GrainDto getGrainById(Long grainId);

    List<GrainDto> getAllGrains();

    GrainDto convertToDto(Grain grain);

    Grain convertToentity(GrainDto grainDto);
}
