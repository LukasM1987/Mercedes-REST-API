package com.restap.carshop.domain;

import com.restap.carshop.repository.SeatRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatTestSuite {

    @Autowired
    private SeatRepository seatRepository;

    @Test
    public void addSeatTestSuite() {
        //Given
        Seat seat = new Seat("Type", "Material", "Color", 99.99);

        //When
        seatRepository.save(seat);
        Long id = seat.getId();
        Optional<Seat> testSeat = seatRepository.findById(id);

        //Then
        assertTrue(testSeat.isPresent());
        assertNotNull(id);

        //Clean Up
        seatRepository.deleteById(id);
    }
}
