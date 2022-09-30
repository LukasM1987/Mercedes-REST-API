package com.restap.carshop.service;

import com.restap.carshop.domain.ModelExemplar;
import com.restap.carshop.exception.EngineExemplarException;
import com.restap.carshop.exception.ModelExemplarException;
import com.restap.carshop.repository.ModelExemplarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelExemplarsService {

    private ModelExemplarRepository modelExemplarRepository;

    @Autowired
    public ModelExemplarsService(ModelExemplarRepository modelExemplarRepository) {
        this.modelExemplarRepository = modelExemplarRepository;
    }

    public ModelExemplar addModelExemplar(final ModelExemplar modelExemplar) {
        return modelExemplarRepository.save(modelExemplar);
    }

    public List<ModelExemplar> findAllModelExemplars() {
        return modelExemplarRepository.findAll();
    }

    public ModelExemplar findModelExemplarById(final Long id) throws ModelExemplarException {
        return modelExemplarRepository.findById(id).orElseThrow(ModelExemplarException::new);
    }

    public ModelExemplar findModelExemplarBySerialNumber(final String serialNumber) throws ModelExemplarException {
        return modelExemplarRepository.findByVin(serialNumber).orElseThrow(ModelExemplarException::new);
    }

    public ModelExemplar findModelExemplarByAvailable(final boolean available) throws ModelExemplarException {
        return modelExemplarRepository.findByAvailable(available).orElseThrow(ModelExemplarException::new);
    }

    public void deleteModelExemplar(final Long id) throws ModelExemplarException {
        if (modelExemplarRepository.findById(id).isPresent()) {
            modelExemplarRepository.findById(id);
        } else {
            throw new ModelExemplarException();
        }
    }
}
