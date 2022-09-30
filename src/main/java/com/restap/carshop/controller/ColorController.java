package com.restap.carshop.controller;

import com.restap.carshop.domain.Color;
import com.restap.carshop.dto.ColorDto;
import com.restap.carshop.exception.ColorException;
import com.restap.carshop.mapper.ColorMapper;
import com.restap.carshop.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/colors")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;
    private final ColorMapper colorMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addColor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addColor(@RequestBody final ColorDto colorDto) {
        Color color = colorMapper.mapToColor(colorDto);
        colorService.addColor(color);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteColor")
    public void deleteColor(final Long id) throws ColorException {
        if (colorService.getColor(id).isPresent()) {
            colorService.deleteColor(id);
        } else {
            throw new ColorException();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getColors")
    public List<ColorDto> getColors() {
        List<Color> colors = colorService.getAllColors();
        return colorMapper.mapToColorDtoList(colors);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getColor")
    public ColorDto getColorById(@RequestParam final Long id) throws ColorException {
        return colorMapper.mapToColorDto(colorService.getColor(id).orElseThrow(ColorException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getColorByName")
    public ColorDto getColorByName(@RequestParam final String name) throws ColorException {
        return colorMapper.mapToColorDto(colorService.getColorByName(name).orElseThrow(ColorException::new));
    }
}
