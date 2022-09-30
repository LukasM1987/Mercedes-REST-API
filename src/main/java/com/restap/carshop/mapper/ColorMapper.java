package com.restap.carshop.mapper;

import com.restap.carshop.domain.Color;
import com.restap.carshop.dto.ColorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorMapper {

    public Color mapToColor(final ColorDto colorDto) {
        return new Color(colorDto.getId(), colorDto.getColorName(), colorDto.getPrice());
    }

    public ColorDto mapToColorDto(final Color color) {
        return new ColorDto(color.getId(), color.getColorName(), color.getPrice());
    }

    public List<ColorDto> mapToColorDtoList(final List<Color> colors) {
        return colors.stream().map(this::mapToColorDto).collect(Collectors.toList());
    }
}
