package com.Catalog.Service.service.ServiceImpl;
import com.Catalog.Service.dto.GrainDto;
import com.Catalog.Service.service.CatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Catalog.Service.entity.Grain;
import com.Catalog.Service.repo.GrainRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    ModelMapper modelMapper;

    private final GrainRepository grainRepository;


    @Autowired
    public CatalogServiceImpl(GrainRepository grainRepository) {
        this.grainRepository = grainRepository;
    }

    @Override
    public GrainDto createGrain(GrainDto newGrain) {
        Grain grain = convertToentity(newGrain);
        Grain grains = grainRepository.save(grain);
         return  convertToDto(grains);

    }

    @Override
    public GrainDto getGrainById(Long grainId) {
        Grain grainsByID = grainRepository.getById(grainId);
        return convertToDto(grainsByID);
    }

    @Override
    public List<GrainDto> getAllGrains() {
        // Retrieve a list of all grains from the database
        List<Grain> all = grainRepository.findAll();
        return all.stream().map(x -> convertToDto(x)).collect(Collectors.toList());

    }
    @Override
    public GrainDto convertToDto(Grain grain) {
        return modelMapper.map(grain, GrainDto.class);
    }
    @Override
    public Grain convertToentity(GrainDto grainDto) {
        return modelMapper.map(grainDto, Grain.class);
    }

}
