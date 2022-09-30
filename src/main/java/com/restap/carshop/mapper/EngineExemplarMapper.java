package com.restap.carshop.mapper;

import com.restap.carshop.domain.Engine;
import com.restap.carshop.domain.EngineExemplar;
import com.restap.carshop.dto.EngineDto;
import com.restap.carshop.dto.EngineExemplarDto;
import com.restap.carshop.exception.EngineException;
import com.restap.carshop.repository.EngineExemplarRepository;
import com.restap.carshop.repository.EngineRepository;
import com.restap.carshop.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngineExemplarMapper {

    @Autowired
    private EngineService engineService;

    public EngineExemplar mapToEngineExemplar(final EngineExemplarDto engineExemplarDto) throws EngineException {
        EngineExemplar engineExemplar = new EngineExemplar(engineExemplarDto.getId(),
                engineExemplarDto.getSerialNumber(),
                engineExemplarDto.isAvailable());
        engineExemplar.setEngine(engineService.getEngineById(engineExemplarDto.getEngineId()));
        return engineExemplar;
    }

    public EngineExemplarDto mapToEngineExemplarDto(final EngineExemplar engineExemplar) {
        return new EngineExemplarDto(engineExemplar.getId(),
                engineExemplar.getSerialNumber(),
                engineExemplar.isAvailable(),
                engineExemplar.getEngine().getId());
    }

    public List<EngineExemplarDto> mapToEngineExemplarDtoList(final List<EngineExemplar> engineExemplars) {
        return engineExemplars.stream().map(this::mapToEngineExemplarDto).collect(Collectors.toList());
    }

    //private EngineRepository engineRepository;

    /*
    public EngineExemplar mapToEngineExemplar(final EngineExemplarDto engineExemplarDto) {
        return new EngineExemplar(engineExemplarDto.getId(),
                engineExemplarDto.getSerialNumber(),
                engineExemplarDto.isAvailable(),
                engineRepository.findById(engineExemplarDto.getId()).get());
    }

    public EngineExemplarDto mapToEngineExemplarDto(final EngineExemplar engineExemplar) {
        return new EngineExemplarDto(engineExemplar.getId(),
                engineExemplar.getSerialNumber(),
                engineExemplar.isAvailable(),
                engineExemplar.getEngine().getId());
    }

    public List<EngineExemplarDto> mapToEngineExemplarDtoList(final List<EngineExemplar> engineExemplars) {
        return engineExemplars.stream().map(this::mapToEngineExemplarDto).collect(Collectors.toList());
    }
    */
}
