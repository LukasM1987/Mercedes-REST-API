package com.restap.carshop.domain;

import com.restap.carshop.repository.OrderRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTestSuite {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void addOrderTest() {
        //Given
        /*
        Engine engine = new Engine(1L, "Petrol V6", 354, 30000.00, new ArrayList<>());
        Model model = new Model(1L, "Sedan", 250000.00, new ArrayList<>());
        GearBox gearBox = new GearBox(1L, "Automatic", 5, 20000.00, new ArrayList<>());

        EngineExemplar engineExemplar = new EngineExemplar(1L, "WS5487S34", engine);
        ModelExemplar modelExemplar = new ModelExemplar(1L, "EHV184750905038VC374", model);
        GearBoxExemplar gearBoxExemplar = new GearBoxExemplar(1L, "ERT48300CF", gearBox);

        Color color = new Color(1L, "Black Pearl", 20000.00, new ArrayList<>());
        Drive drive = new Drive(1L, "Rear", 15000.00, new ArrayList<>());
        Seat seat = new Seat(1L, "Heated", "Leather", "Black", 10000.00, new ArrayList<>());

        User user = new User(1L, 870207, "Lukasz", "Marchel", "Podkowa lesna", "Sokola", "23", null, new ArrayList<>());
        Car car = new Car(1L, modelExemplar, engineExemplar, gearBoxExemplar, color, drive, seat);
        Order order = new Order(1L, user, LocalDateTime.now(), car);

        //When
        orderRepository.save(order);
        Optional<Order> testOrder = orderRepository.findById(order.getId());

        //Then
        assertTrue(testOrder.isPresent());
        assertNotNull(order.getId());
        */

    }
}
