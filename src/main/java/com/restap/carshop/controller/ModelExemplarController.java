package com.restap.carshop.controller;

import com.restap.carshop.domain.ModelExemplar;
import com.restap.carshop.dto.ModelExemplarDto;
import com.restap.carshop.exception.ModelException;
import com.restap.carshop.exception.ModelExemplarException;
import com.restap.carshop.mapper.ModelExemplarMapper;
import com.restap.carshop.service.ModelExemplarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/modelExemplars")
@RequiredArgsConstructor
public class ModelExemplarController {

    private final ModelExemplarMapper modelExemplarMapper;
    private final ModelExemplarsService modelExemplarsService;

    @RequestMapping(method = RequestMethod.POST, value = "addModelExemplar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addModelExemplar(final ModelExemplarDto modelExemplarDto) throws ModelException {
        ModelExemplar modelExemplar = modelExemplarMapper.mapToModelExemplar(modelExemplarDto);
        modelExemplarsService.addModelExemplar(modelExemplar);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteModelExemplar")
    public void deleteModelExemplar(final Long id) throws ModelExemplarException {
            modelExemplarsService.deleteModelExemplar(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelsExemplars")
    public List<ModelExemplarDto> getModelsExemplars() {
        List<ModelExemplar> modelExemplars = modelExemplarsService.findAllModelExemplars();
        return modelExemplarMapper.mapToModelExemplarDtoList(modelExemplars);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelExemplarById")
    public ModelExemplarDto getModelExemplarById(final Long id) throws ModelExemplarException {
        return modelExemplarMapper.mapToModelExemplarDto(
                modelExemplarsService.findModelExemplarById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelExemplarBySerialNumber")
    public ModelExemplarDto getModelExemplarBySerialNumber(final String serialNumber) throws ModelExemplarException {
        return modelExemplarMapper.mapToModelExemplarDto(
                modelExemplarsService.findModelExemplarBySerialNumber(serialNumber));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getModelExemplarByAvailable")
    public ModelExemplarDto getModelExemplarByAvailable(final boolean available) throws ModelExemplarException {
        return modelExemplarMapper.mapToModelExemplarDto(
                modelExemplarsService.findModelExemplarByAvailable(available));
    }
}
