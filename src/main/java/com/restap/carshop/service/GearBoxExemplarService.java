package com.restap.carshop.service;

import com.restap.carshop.domain.GearBoxExemplar;
import com.restap.carshop.exception.GearBoxExemplarException;
import com.restap.carshop.repository.GearBoxesExemplarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GearBoxExemplarService {

    private GearBoxesExemplarsRepository gearBoxesExemplarsRepository;

    @Autowired
    public GearBoxExemplarService(GearBoxesExemplarsRepository gearBoxesExemplarsRepository) {
        this.gearBoxesExemplarsRepository = gearBoxesExemplarsRepository;
    }

    public GearBoxExemplar addGearBoxExemplar(final GearBoxExemplar gearBoxExemplar) {
        return gearBoxesExemplarsRepository.save(gearBoxExemplar);
    }

    public List<GearBoxExemplar> findAllGearBoxesExemplars() {
        return gearBoxesExemplarsRepository.findAll();
    }

    public GearBoxExemplar findGearBoxExemplarById(final Long id) throws GearBoxExemplarException {
        return gearBoxesExemplarsRepository.findById(id).orElseThrow(GearBoxExemplarException::new);
    }

    public void deleteGearBoxExemplar(final Long id) throws GearBoxExemplarException {
        if (gearBoxesExemplarsRepository.findById(id).isPresent()) {
            gearBoxesExemplarsRepository.deleteById(id);
        } else {
            throw new GearBoxExemplarException();
        }
    }

    public GearBoxExemplar findGearBoxExemplarBySerialNumber(final String serialNumber) throws GearBoxExemplarException {
        return gearBoxesExemplarsRepository.findBySerialNumber(serialNumber).orElseThrow(GearBoxExemplarException::new);
    }

    public GearBoxExemplar findEngineExemplarByAvailable(final boolean available) throws GearBoxExemplarException {
        return gearBoxesExemplarsRepository.findByAvailable(available).orElseThrow(GearBoxExemplarException::new);
    }
}
