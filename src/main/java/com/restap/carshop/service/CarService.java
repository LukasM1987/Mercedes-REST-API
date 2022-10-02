package com.restap.carshop.service;

import com.restap.carshop.domain.Car;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.exception.*;
import com.restap.carshop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(final Car car) {
        return carRepository.save(car);
    }

    public Car findCarById(final Long carId) throws CarException {
        return carRepository.findById(carId).orElseThrow(CarException::new);
    }

    public void deleteCar(final Long carId) throws CarException {
        if (carRepository.findById(carId).isPresent()) {
            carRepository.deleteById(carId);
        } else {
            throw new CarException();
        }
    }
}
