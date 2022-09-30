package com.restap.carshop.mapper;

import com.restap.carshop.domain.Engine;
import com.restap.carshop.dto.EngineDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngineMapper {

    public Engine mapToEngine(final EngineDto engineDto) {
        return new Engine(engineDto.getId(), engineDto.getType(), engineDto.getHp(), engineDto.getPrice());
    }

    public EngineDto mapToEngineDto(final Engine engine) {
        return new EngineDto(engine.getId(), engine.getType(), engine.getHp(), engine.getPrice());
    }

    public List<EngineDto> mapToEngineDtoList(final List<Engine> engines) {
        return engines.stream().map(this::mapToEngineDto).collect(Collectors.toList());
    }
}
