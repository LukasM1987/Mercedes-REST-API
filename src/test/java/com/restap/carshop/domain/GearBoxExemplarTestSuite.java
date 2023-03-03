package com.restap.carshop.domain;

import com.restap.carshop.repository.GearBoxRepository;
import com.restap.carshop.repository.GearBoxesExemplarsRepository;
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
public class GearBoxExemplarTestSuite {

    @Autowired
    private GearBoxesExemplarsRepository gearBoxesExemplarsRepository;

    @Autowired
    private GearBoxRepository gearBoxRepository;

    @Test
    public void addGearBoxExemplarTest() {
        //Given
        GearBox gearBox = new GearBox("Type", 6, 99.99);
        GearBoxExemplar gearBoxExemplar = new GearBoxExemplar("0000000000", true);

        //When
        gearBoxRepository.save(gearBox);
        gearBoxesExemplarsRepository.save(gearBoxExemplar);
        gearBox.getGearBoxExemplarList().add(gearBoxExemplar);
        gearBoxExemplar.setGearbox(gearBox);
        Long id = gearBoxExemplar.getId();
        Optional<GearBoxExemplar> gearBoxExemplarTest = gearBoxesExemplarsRepository.findById(id);

        //Then
        assertTrue(gearBoxExemplarTest.isPresent());
        assertNotNull(id);

        //Clean Up
        gearBoxRepository.deleteById(gearBox.getId());
        gearBoxesExemplarsRepository.deleteById(id);
    }
}
