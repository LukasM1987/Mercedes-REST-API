package com.restap.carshop.controller;

import com.restap.carshop.domain.GearBoxExemplar;
import com.restap.carshop.dto.GearBoxExemplarDto;
import com.restap.carshop.exception.GearBoxException;
import com.restap.carshop.exception.GearBoxExemplarException;
import com.restap.carshop.mapper.GearBoxExemplarMapper;
import com.restap.carshop.service.GearBoxExemplarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/gearBoxesExemplars")
@RequiredArgsConstructor
public class GearBoxExemplarController {

    private final GearBoxExemplarMapper gearBoxExemplarMapper;
    private final GearBoxExemplarService gearBoxExemplarService;

    @RequestMapping(method = RequestMethod.POST, value = "addGearBoxExemplar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGearBoxExemplar(final GearBoxExemplarDto gearBoxExemplarDto) throws GearBoxException {
        GearBoxExemplar gearBoxExemplar = gearBoxExemplarMapper.mapToGearBoxExemplar(gearBoxExemplarDto);
        gearBoxExemplarService.addGearBoxExemplar(gearBoxExemplar);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGearBoxExemplar")
    public void deleteGearBoxExemplar(final Long id) throws GearBoxExemplarException {
        gearBoxExemplarService.deleteGearBoxExemplar(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBoxesExemplars")
    public List<GearBoxExemplarDto> getGearBoxesExemplars() {
        List<GearBoxExemplar> gearBoxExemplars = gearBoxExemplarService.findAllGearBoxesExemplars();
        return gearBoxExemplarMapper.mapToGearBoxesExemplarsDtoList(gearBoxExemplars);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBoxExemplarById")
    public GearBoxExemplarDto getGearBoxExemplarById(final Long id) throws GearBoxExemplarException {
        return gearBoxExemplarMapper.mapToGearBoxExemplarDto(
                gearBoxExemplarService.findGearBoxExemplarById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBoxExemplarBySerialNumber")
    public GearBoxExemplarDto getGearBoxExemplarBySerialNumber(final String serialNumber) throws GearBoxExemplarException {
        return gearBoxExemplarMapper.mapToGearBoxExemplarDto(
                gearBoxExemplarService.findGearBoxExemplarBySerialNumber(serialNumber));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBoxExemplarByAvailable")
    public GearBoxExemplarDto getGearBoxExemplarByAvailable(final boolean available) throws GearBoxExemplarException {
        return gearBoxExemplarMapper.mapToGearBoxExemplarDto(
                gearBoxExemplarService.findEngineExemplarByAvailable(available));
    }
}
