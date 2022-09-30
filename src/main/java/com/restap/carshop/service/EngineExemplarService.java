package com.restap.carshop.service;

import com.restap.carshop.domain.EngineExemplar;
import com.restap.carshop.exception.EngineExemplarException;
import com.restap.carshop.repository.EngineExemplarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EngineExemplarService {

    private EngineExemplarRepository engineExemplarRepository;

    @Autowired
    public EngineExemplarService(EngineExemplarRepository engineExemplarRepository) {
        this.engineExemplarRepository = engineExemplarRepository;
    }

    public List<EngineExemplar> findAllEnginesExemplars() {
        return engineExemplarRepository.findAll();
    }

    public EngineExemplar findEngineExemplarById(final Long id) throws EngineExemplarException {
        return engineExemplarRepository.findById(id).orElseThrow(EngineExemplarException::new);
    }

    public EngineExemplar addEngineExemplar(final EngineExemplar engineExemplar) {
        return engineExemplarRepository.save(engineExemplar);
    }

    public void deleteEngineExemplar(final Long id) throws EngineExemplarException {
        if (engineExemplarRepository.findById(id).isPresent()) {
            engineExemplarRepository.deleteById(id);
        } else {
            throw new EngineExemplarException();
        }
    }

    public Optional<EngineExemplar> findEngineExemplarBySerialNumber(final String serialNumber) {
        return engineExemplarRepository.findBySerialNumber(serialNumber);
    }

    public Optional<EngineExemplar> findEngineExemplarByAvailable(final boolean available) {
        return engineExemplarRepository.findByAvailable(available);
    }
}
