package com.restap.carshop.controller;

import com.restap.carshop.domain.Engine;
import com.restap.carshop.dto.EngineDto;
import com.restap.carshop.exception.EngineException;
import com.restap.carshop.mapper.EngineMapper;
import com.restap.carshop.service.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/engines")
@RequiredArgsConstructor
public class EngineController {

    private final EngineMapper engineMapper;
    private final EngineService engineService;

    @RequestMapping(method = RequestMethod.POST, value = "addEngine", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEngine(@RequestBody final EngineDto engineDto) {
        Engine engine = engineMapper.mapToEngine(engineDto);
        engineService.addEngine(engine);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteEngine")
    public void deleteEngine(@RequestParam final Long id) {
        engineService.deleteEngine(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEngines")
    public List<EngineDto> getEngines() {
        List<Engine> engines = engineService.getAllEngines();
        return engineMapper.mapToEngineDtoList(engines);
    }


    @RequestMapping(method = RequestMethod.GET, value = "getEngine")
    public EngineDto getEngine(@RequestParam final Long id) throws EngineException {
        return engineMapper.mapToEngineDto(engineService.getEngineById(id));
    }
}
