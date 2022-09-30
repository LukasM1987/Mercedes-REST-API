package com.restap.carshop.controller;

import com.restap.carshop.domain.GearBox;
import com.restap.carshop.dto.GearBoxDto;
import com.restap.carshop.exception.GearBoxException;
import com.restap.carshop.mapper.GearBoxMapper;
import com.restap.carshop.service.GearBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/gearBoxes")
@RequiredArgsConstructor
public class GearBoxController {

    private final GearBoxMapper gearBoxMapper;
    private final GearBoxService gearBoxService;

    @RequestMapping(method = RequestMethod.POST, value = "addGearBox", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGearBox(@RequestBody final GearBoxDto gearBoxDto) {
        GearBox gearBox = gearBoxMapper.mapToGarBox(gearBoxDto);
        gearBoxService.addGearBox(gearBox);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGearBox")
    public void deleteGearBox(@RequestParam final Long id) throws GearBoxException {
            gearBoxService.deleteGearBox(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBoxes")
    public List<GearBoxDto> getGearBoxes() {
        List<GearBox> gearBoxes = gearBoxService.getAllGearBoxes();
        return gearBoxMapper.mapToGearBoxDtoList(gearBoxes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getGearBox")
    public GearBoxDto getGearBox(@RequestParam final Long id) throws GearBoxException {
        return gearBoxMapper.mapToGearBoxDto(gearBoxService.getGearBoxById(id));
    }
}
