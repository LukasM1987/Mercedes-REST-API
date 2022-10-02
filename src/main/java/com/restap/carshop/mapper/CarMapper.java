package com.restap.carshop.mapper;

import com.restap.carshop.domain.Car;
import com.restap.carshop.dto.CarDto;
import com.restap.carshop.exception.*;
import com.restap.carshop.service.*;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    private ModelExemplarsService modelExemplarService;
    private EngineExemplarService engineExemplarService;
    private GearBoxExemplarService gearBoxesExemplarsService;
    private ColorService colorService;
    private DriveService driveService;
    private SeatService seatService;

    private double modelPrice, enginePrice, gearBoxPrice, colorPrice, drivePrice, seatPrice;

    public Car mapToCar(final CarDto carDto) throws ModelExemplarException, EngineExemplarException, GearBoxExemplarException, ColorException, DriveException, SeatException {
        Car car = new Car(carDto.getId());
        car.setModelExemplar(modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()));
        car.setEngineExemplar(engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()));
        car.setGearBoxExemplar(gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()));
        car.setColor(colorService.getColorById(carDto.getColorId()));
        car.setDrive(driveService.getDriveById(carDto.getDriveId()));
        car.setSeat(seatService.getSeatById(carDto.getSeatId()));

        /*
        modelPrice = modelExemplarService.findModelExemplarById(carDto.getModelExemplarId()).getModel().getPrice();
        enginePrice = engineExemplarService.findEngineExemplarById(carDto.getEngineExemplarId()).getEngine().getPrice();
        gearBoxPrice = gearBoxesExemplarsService.findGearBoxExemplarById(carDto.getGearBoxExemplarId()).getGearbox().getPrice();
        colorPrice = colorService.getColorById(carDto.getColorId()).getPrice();
        drivePrice = driveService.getDriveById(carDto.getDriveId()).getPrice();
        seatPrice = seatService.getSeatById(carDto.getSeatId()).getPrice();
        car.setCarPrice(carDto.getQuantity() * (modelPrice + enginePrice + gearBoxPrice + colorPrice + drivePrice + seatPrice));
        */

        return car;
    }

    public CarDto mapToDriveDto(final Car car) {
        return new CarDto(car.getInd(),
                //car.getCarPrice(),
                car.getModelExemplar().getId(),
                car.getEngineExemplar().getId(),
                car.getGearBoxExemplar().getId(),
                car.getColor().getId(),
                car.getDrive().getId(),
                car.getSeat().getId());
    }
}
