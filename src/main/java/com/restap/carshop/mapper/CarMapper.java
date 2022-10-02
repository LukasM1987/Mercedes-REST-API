package com.restap.carshop.mapper;

import com.restap.carshop.domain.Car;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.exception.*;
import com.restap.carshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    @Autowired
    private ModelExemplarsService modelExemplarService;
    @Autowired
    private EngineExemplarService engineExemplarService;
    @Autowired
    private GearBoxExemplarService gearBoxesExemplarsService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private DriveService driveService;
    @Autowired
    private SeatService seatService;

    private double modelPrice, enginePrice, gearBoxPrice, colorPrice, drivePrice, seatPrice;

    public Car mapToCar(final CarDto carDto) throws ModelExemplarException, EngineExemplarException, GearBoxExemplarException, ColorException, DriveException, SeatException {
        Car car = new Car(carDto.getId());
        if (modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()).isAvailable()) {
            car.setModelExemplar(modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()));
            modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()).setAvailable(false);
        } else {
            throw new ModelExemplarException();
        }
        if (engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()).isAvailable()) {
            car.setEngineExemplar(engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()));
            engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()).setAvailable(false);
        } else {
            throw new EngineExemplarException();
        }
        if (gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()).isAvailable()) {
            car.setGearBoxExemplar(gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()));
            gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()).setAvailable(false);
        } else {
            throw new GearBoxExemplarException();
        }
        car.setColor(colorService.getColorById(carDto.getColorId()));
        car.setDrive(driveService.getDriveById(carDto.getDriveId()));
        car.setSeat(seatService.getSeatById(carDto.getSeatId()));

        modelPrice = modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()).getModel().getPrice();
        enginePrice = engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()).getEngine().getPrice();
        gearBoxPrice = gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()).getGearbox().getPrice();
        colorPrice = colorService.getColorById(carDto.getColorId()).getPrice();
        drivePrice = driveService.getDriveById(carDto.getDriveId()).getPrice();
        seatPrice = seatService.getSeatById(carDto.getSeatId()).getPrice();
        car.setCarPrice(modelPrice + enginePrice + gearBoxPrice + colorPrice + drivePrice + seatPrice);
        return car;
    }

    public CarDto mapToDriveDto(final Car car) {
        return new CarDto(car.getId(),
                car.getCarPrice(),
                car.getModelExemplar().getId(),
                car.getEngineExemplar().getId(),
                car.getGearBoxExemplar().getId(),
                car.getColor().getId(),
                car.getDrive().getId(),
                car.getSeat().getId());
    }
}
