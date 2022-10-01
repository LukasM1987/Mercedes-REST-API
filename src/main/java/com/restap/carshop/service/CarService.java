package com.restap.carshop.service;

import com.restap.carshop.domain.Car;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.exception.*;
import com.restap.carshop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final ModelExemplarRepository modelExemplarRepository;
    private final EngineExemplarRepository engineExemplarRepository;
    private final GearBoxesExemplarsRepository gearBoxesExemplarsRepository;

    private final ColorRepository colorRepository;
    private final DriveRepository driveRepository;
    private final SeatRepository seatRepository;
    private final CarRepository carRepository;

    private double modelPrice, enginePrice, gearBoxPrice, colorPrice, drivePrice, seatPrice;

    /*
    public Car createCar(final Long modelExemplarId,
                         final Long engineExemplarId,
                         final Long gearBoxExemplarId,
                         final Long colorId,
                         final Long driveId,
                         final Long seatId,
                         final int quantity) throws EngineExemplarException, ModelExemplarException,
            GearBoxExemplarException, ColorException, DriveException, SeatException {
        Car car = new Car();
        car.setQuantity(quantity);
        car.setModelExemplar(modelExemplarRepository.findById(modelExemplarId)
                .orElseThrow(ModelExemplarException::new));
        car.setEngineExemplar(engineExemplarRepository.findById(engineExemplarId)
                .orElseThrow(EngineExemplarException::new));
        car.setGearBoxExemplar(gearBoxesExemplarsRepository.findById(gearBoxExemplarId)
                .orElseThrow(GearBoxExemplarException::new));
        car.setColor(colorRepository.findById(colorId).orElseThrow(ColorException::new));
        car.setDrive(driveRepository.findById(driveId).orElseThrow(DriveException::new));
        car.setSeat(seatRepository.findById(seatId).orElseThrow(SeatException::new));

        modelPrice = modelExemplarRepository.findById(modelExemplarId)
                .orElseThrow(ModelExemplarException::new).getModel().getPrice();
        enginePrice = engineExemplarRepository.findById(engineExemplarId)
                .orElseThrow(EngineExemplarException::new).getEngine().getPrice();
        gearBoxPrice = gearBoxesExemplarsRepository.findById(gearBoxExemplarId)
                .orElseThrow(GearBoxExemplarException::new).getGearbox().getPrice();
        colorPrice = colorRepository.findById(colorId).orElseThrow(ColorException::new).getPrice();
        drivePrice = driveRepository.findById(driveId).orElseThrow(DriveException::new).getPrice();
        seatPrice = seatRepository.findById(seatId).orElseThrow(SeatException::new).getPrice();
        car.setCarPrice(quantity * (modelPrice + enginePrice + gearBoxPrice + colorPrice + drivePrice + seatPrice));
        return car;
    }
    */

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
