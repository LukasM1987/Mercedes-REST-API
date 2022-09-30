package com.restap.carshop.mapper;

import com.restap.carshop.domain.GearBoxExemplar;
import com.restap.carshop.dto.GearBoxExemplarDto;
import com.restap.carshop.exception.GearBoxException;
import com.restap.carshop.service.GearBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GearBoxExemplarMapper {

    @Autowired
    private GearBoxService gearBoxService;

    public GearBoxExemplar mapToGearBoxExemplar(final GearBoxExemplarDto gearBoxExemplarDto) throws  GearBoxException {
        GearBoxExemplar gearBoxExemplar = new GearBoxExemplar(gearBoxExemplarDto.getId(),
                gearBoxExemplarDto.getSerialNumber(),
                gearBoxExemplarDto.isAvailable());
        gearBoxExemplar.setGearbox(gearBoxService.getGearBoxById(gearBoxExemplarDto.getGearBoxId()));
        return gearBoxExemplar;
    }

    public GearBoxExemplarDto mapToGearBoxExemplarDto(final GearBoxExemplar gearBoxExemplar) {
        return new GearBoxExemplarDto(gearBoxExemplar.getId(),
                gearBoxExemplar.getSerialNumber(),
                gearBoxExemplar.isAvailable(),
                gearBoxExemplar.getGearbox().getId());
    }

    public List<GearBoxExemplarDto> mapToGearBoxesExemplarsDtoList(final List<GearBoxExemplar> gearBoxesExemplars) {
        return gearBoxesExemplars.stream().map(this::mapToGearBoxExemplarDto).collect(Collectors.toList());
    }
}
