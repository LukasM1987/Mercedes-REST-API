package com.restap.carshop.controller;

import com.restap.carshop.domain.Model;
import com.restap.carshop.dto.ModelDto;
import com.restap.carshop.exception.ModelException;
import com.restap.carshop.mapper.ModelMapper;
import com.restap.carshop.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelMapper modelMapper;
    private final ModelService modelService;

    @RequestMapping(method = RequestMethod.POST, value = "addModel", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addModel(@RequestBody final ModelDto modelDto) {
        Model model = modelMapper.mapToModel(modelDto);
        modelService.addModel(model);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteModel")
    public void deleteModel(@RequestParam final Long id) {
        modelService.deleteModel(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllModels")
    public List<ModelDto> getModels() {
        List<Model> models = modelService.gatAllModels();
        return modelMapper.mapToModelDtoList(models);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelById")
    public ModelDto getModel(@RequestParam final Long id) throws ModelException {
        return modelMapper.mapToModelDto(modelService.getModelById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelByType")
    public ModelDto getModelByType(@RequestParam final String type) throws ModelException {
        return modelMapper.mapToModelDto(modelService.getModelByType(type));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelByClass")
    public ModelDto getModelByClass(@RequestParam final String classType) throws ModelException {
        return modelMapper.mapToModelDto(modelService.getModelByCarClass(classType));
    }
}
