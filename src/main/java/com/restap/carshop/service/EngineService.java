package com.restap.carshop.service;

import com.restap.carshop.domain.Engine;
import com.restap.carshop.exception.EngineException;
import com.restap.carshop.repository.EngineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineService {

    private final EngineRepository engineRepository;

    public Engine addEngine(final Engine engine) {
        return engineRepository.save(engine);
    }

    public List<Engine> getAllEngines() {
        return engineRepository.findAll();
    }

    public Engine getEngineById(final Long id) throws EngineException {
        return engineRepository.findById(id).orElseThrow(EngineException::new);
    }

    public void deleteEngine(final Long id) {
        engineRepository.deleteById(id);
    }
}
