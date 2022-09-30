package com.restap.carshop.mapper;

import com.restap.carshop.domain.GearBox;
import com.restap.carshop.dto.GearBoxDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GearBoxMapper {

    public GearBox mapToGarBox(final GearBoxDto gearBoxDto) {
        return new GearBox(gearBoxDto.getId(), gearBoxDto.getType(),
                gearBoxDto.getGearsQuantity(), gearBoxDto.getPrice());
    }

    public GearBoxDto mapToGearBoxDto(final GearBox gearBox) {
        return new GearBoxDto(gearBox.getId(), gearBox.getType(),
                gearBox.getGearsQuantity(), gearBox.getPrice());
    }

    public List<GearBoxDto> mapToGearBoxDtoList(final List<GearBox> gearBoxes) {
        return gearBoxes.stream().map(this::mapToGearBoxDto).collect(Collectors.toList());
    }
}
