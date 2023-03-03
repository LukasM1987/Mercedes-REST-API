package com.restap.carshop.domain;

import com.restap.carshop.repository.GearBoxRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GearBoxTestSuite {

    @Autowired
    private GearBoxRepository gearBoxRepository;

    @Test
    public void addGearBoxTest() {
        //Given
        GearBox gearBox = new GearBox("Type", 6, 99.99);

        //When
        gearBoxRepository.save(gearBox);
        Long id = gearBox.getId();
        Optional<GearBox> testGearBox = gearBoxRepository.findById(id);

        //Then
        assertTrue(testGearBox.isPresent());
        assertNotNull(id);

        //Clean Up
        gearBoxRepository.deleteById(id);
    }
}
