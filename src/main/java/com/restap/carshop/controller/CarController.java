package com.restap.carshop.controller;

import com.restap.carshop.domain.Car;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.exception.*;
import com.restap.carshop.mapper.CarMapper;
import com.restap.carshop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {

    private CarMapper carMapper;
    private CarService carService;

    @RequestMapping(method = RequestMethod.POST, value = "addCar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCar(@RequestBody final CarDto carDto) throws DriveException, ColorException, SeatException, EngineExemplarException, GearBoxExemplarException, ModelExemplarException {
        Car car = carMapper.mapToCar(carDto);
        carService.addCar(car);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCar")
    public CarDto getCar(@RequestParam final Long id) throws CarException {
        return carMapper.mapToDriveDto(carService.findCarById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCar")
    public void deleteCar(final Long id) throws CarException {
        carService.deleteCar(id);
    }
}
