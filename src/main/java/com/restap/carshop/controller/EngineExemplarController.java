package com.restap.carshop.controller;

import com.restap.carshop.domain.EngineExemplar;
import com.restap.carshop.dto.EngineExemplarDto;
import com.restap.carshop.exception.EngineException;
import com.restap.carshop.exception.EngineExemplarException;
import com.restap.carshop.mapper.EngineExemplarMapper;
import com.restap.carshop.service.EngineExemplarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/engineExemplars")
@RequiredArgsConstructor
public class EngineExemplarController {

    private final EngineExemplarMapper engineExemplarMapper;
    private final EngineExemplarService engineExemplarService;

    @RequestMapping(method = RequestMethod.POST, value = "addEngineExemplar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEngineExemplar(@RequestBody final EngineExemplarDto engineExemplarDto) throws EngineException {
        EngineExemplar engineExemplar = engineExemplarMapper.mapToEngineExemplar(engineExemplarDto);
        engineExemplarService.addEngineExemplar(engineExemplar);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEngineExemplarById")
    public EngineExemplarDto getEngineExemplarById(final Long id) throws EngineExemplarException {
        return engineExemplarMapper.mapToEngineExemplarDto(engineExemplarService.findEngineExemplarById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteEngineExemplar")
    public void deleteEngineExemplar(final Long id) throws EngineExemplarException {
        engineExemplarService.deleteEngineExemplar(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEnginesExemplars")
    public List<EngineExemplarDto> getEnginesExemplars() {
        List<EngineExemplar> engineExemplars = engineExemplarService.findAllEnginesExemplars();
        return engineExemplarMapper.mapToEngineExemplarDtoList(engineExemplars);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEngineExemplarBySerialNumber")
    public EngineExemplarDto getEngineExemplarBySerialNumber(final String serialNumber) throws EngineExemplarException {
        return engineExemplarMapper.mapToEngineExemplarDto(
                engineExemplarService.findEngineExemplarBySerialNumber(serialNumber).orElseThrow(EngineExemplarException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEngineExemplarByAvailable")
    public EngineExemplarDto getEngineExemplarByAvailable(final boolean available) throws EngineExemplarException {
        return engineExemplarMapper.mapToEngineExemplarDto(
                engineExemplarService.findEngineExemplarByAvailable(available).orElseThrow(EngineExemplarException::new));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateEngineExemplar")
    public EngineExemplarDto updateEngineExemplar(@RequestBody final EngineExemplarDto engineExemplarDto) throws EngineException {
        EngineExemplar engineExemplar = engineExemplarMapper.mapToEngineExemplar(engineExemplarDto);
        EngineExemplar updateExemplar = engineExemplarService.addEngineExemplar(engineExemplar);
        return engineExemplarMapper.mapToEngineExemplarDto(updateExemplar);
    }
}
