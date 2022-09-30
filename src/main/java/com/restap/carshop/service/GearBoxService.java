package com.restap.carshop.service;

import com.restap.carshop.domain.GearBox;
import com.restap.carshop.exception.GearBoxException;
import com.restap.carshop.repository.GearBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GearBoxService {

    private final GearBoxRepository gearBoxRepository;

    public GearBox addGearBox(final GearBox gearBox) {
        return gearBoxRepository.save(gearBox);
    }

    public List<GearBox> getAllGearBoxes() {
        return gearBoxRepository.findAll();
    }

    public GearBox getGearBoxById(final Long id) throws GearBoxException {
        return gearBoxRepository.findById(id).orElseThrow(GearBoxException::new);
    }

    public void deleteGearBox(final Long id) {
        gearBoxRepository.deleteById(id);
    }
}
