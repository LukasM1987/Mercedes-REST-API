package com.restap.carshop.domain;

import com.restap.carshop.repository.ColorRepository;
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
public class ColorTestSuite {

    @Autowired
    private ColorRepository colorRepository;

    @Test
    public void addColorTest() {
        //Given
        Color color = new Color("Color", 99.99);

        //When
        colorRepository.save(color);
        Long id = color.getId();
        Optional<Color> colorTest = colorRepository.findById(id);

        //Then
        assertTrue(colorTest.isPresent());
        assertNotNull(id);

        //Clean Up
        colorRepository.deleteById(id);
    }
}
