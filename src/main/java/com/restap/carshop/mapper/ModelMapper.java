package com.restap.carshop.mapper;

import com.restap.carshop.domain.Model;
import com.restap.carshop.dto.ModelDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapper {

    public Model mapToModel(final ModelDto modelDto) {
        return new Model(modelDto.getId(), modelDto.getCarClass(), modelDto.getType(), modelDto.getPrice());
    }

    public ModelDto mapToModelDto(final Model model) {
        return new ModelDto(model.getId(), model.getCarClass(), model.getType(), model.getPrice());
    }

    public List<ModelDto> mapToModelDtoList(final List<Model> models) {
        return models.stream().map(this::mapToModelDto).collect(Collectors.toList());
    }
}
