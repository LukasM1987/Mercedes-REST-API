package com.restap.carshop.service;

import com.restap.carshop.domain.Model;
import com.restap.carshop.exception.ModelException;
import com.restap.carshop.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;

    public Model addModel(final Model model) {
        return modelRepository.save(model);
    }

    public List<Model> gatAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(final Long id) throws ModelException {
        return modelRepository.findById(id).orElseThrow(ModelException::new);
    }

    public Model getModelByType(final String type) throws ModelException {
        return modelRepository.findByType(type).orElseThrow(ModelException::new);
    }

    public Model getModelByCarClass(final String carClass) throws ModelException {
        return modelRepository.findByCarClass(carClass).orElseThrow(ModelException::new);
    }

    public void deleteModel(final Long id) {
        modelRepository.deleteById(id);
    }
}
