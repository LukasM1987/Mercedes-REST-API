package com.restap.carshop.domain;

import com.restap.carshop.repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarTestSuite {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private GearBoxRepository gearBoxRepository;

    @Autowired
    private ModelExemplarRepository modelExemplarRepository;

    @Autowired
    private EngineExemplarRepository engineExemplarRepository;

    @Autowired
    private GearBoxesExemplarsRepository gearBoxesExemplarsRepository;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void addCarTest() {
        //Given
        ModelExemplar modelExemplar = new ModelExemplar("0000000000", true);
        EngineExemplar engineExemplar = new EngineExemplar("0000000000", true);
        GearBoxExemplar gearBoxExemplar = new GearBoxExemplar("0000000000", true);
        Color color = new Color("Color", 99.99);
        Drive drive = new Drive("Drive", 99.99);
        Seat seat = new Seat("Type", "Material", "Color", 99.99);
        Model model = new Model("Car class", "Type", 99.99);
        Engine engine = new Engine("Type", 354, 99.99);
        GearBox gearBox = new GearBox("Type", 6, 99.99);
        Car car = new Car(true);

        //When
        modelRepository.save(model);
        engineRepository.save(engine);
        gearBoxRepository.save(gearBox);
        modelExemplarRepository.save(modelExemplar);
        engineExemplarRepository.save(engineExemplar);
        gearBoxesExemplarsRepository.save(gearBoxExemplar);
        colorRepository.save(color);
        driveRepository.save(drive);
        seatRepository.save(seat);
        carRepository.save(car);

        modelExemplar.setModel(model);
        engineExemplar.setEngine(engine);
        gearBoxExemplar.setGearbox(gearBox);
        model.getModelExemplarList().add(modelExemplar);
        engine.getEngineExemplarList().add(engineExemplar);
        gearBox.getGearBoxExemplarList().add(gearBoxExemplar);
        color.getCarList().add(car);
        drive.getCarList().add(car);
        seat.getCarList().add(car);

        car.setModelExemplar(modelExemplar);
        car.setEngineExemplar(engineExemplar);
        car.setGearBoxExemplar(gearBoxExemplar);
        car.setColor(color);
        car.setDrive(drive);
        car.setSeat(seat);
        car.setCarPrice(car.getColor().getPrice() +
                car.getSeat().getPrice() +
                car.getDrive().getPrice() +
                car.getModelExemplar().getModel().getPrice() +
                car.getEngineExemplar().getEngine().getPrice() +
                car.getGearBoxExemplar().getGearbox().getPrice());

        Long id = car.getId();
        Optional<Car> testCar = carRepository.findById(car.getId());
        double carPrice = car.getCarPrice();

        //Then
        assertTrue(testCar.isPresent());
        assertNotNull(id);
        assertEquals(6 * 99.99, carPrice, 0.001);

        //Clean Up
        colorRepository.deleteById(color.getId());
        driveRepository.deleteById(drive.getId());
        seatRepository.deleteById(seat.getId());
        engineRepository.deleteById(engine.getId());
        gearBoxRepository.deleteById(gearBox.getId());
        modelRepository.deleteById(model.getId());
        engineExemplarRepository.deleteById(engineExemplar.getId());
        gearBoxesExemplarsRepository.deleteById(gearBoxExemplar.getId());
        modelExemplarRepository.deleteById(modelExemplar.getId());
        carRepository.deleteById(car.getId());
    }
}
