package com.restap.carshop.mapper;

import com.restap.carshop.domain.ModelExemplar;
import com.restap.carshop.dto.ModelExemplarDto;
import com.restap.carshop.exception.ModelException;
import com.restap.carshop.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelExemplarMapper {

    @Autowired
    private ModelService modelService;

    public ModelExemplar mapToModelExemplar(final ModelExemplarDto modelExemplarDto) throws ModelException {
        ModelExemplar modelExemplar = new ModelExemplar(modelExemplarDto.getModelId(),
                modelExemplarDto.getVin(),
                modelExemplarDto.isAvailable());
        modelExemplar.setModel(modelService.getModelById(modelExemplarDto.getModelId()));
        return modelExemplar;
    }

    public ModelExemplarDto mapToModelExemplarDto(final ModelExemplar modelExemplar) {
        return new ModelExemplarDto(modelExemplar.getId(),
                modelExemplar.getVin(),
                modelExemplar.isAvailable(),
                modelExemplar.getModel().getId());
    }

    public List<ModelExemplarDto> mapToModelExemplarDtoList(final List<ModelExemplar> modelExemplars) {
        return modelExemplars.stream().map(this::mapToModelExemplarDto).collect(Collectors.toList());
    }
}
