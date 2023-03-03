package com.restap.carshop.domain;

import com.restap.carshop.repository.ModelRepository;
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
public class ModelTestSuite {

    @Autowired
    private ModelRepository modelRepository;

    @Test
    public void addModelTest() {
        //Given
        Model model = new Model("Car class","Type", 99.99);

        //When
        modelRepository.save(model);
        Long id = model.getId();
        Optional<Model> testGearBox = modelRepository.findById(id);

        //Then
        assertTrue(testGearBox.isPresent());
        assertNotNull(id);

        //Clean Up
        modelRepository.deleteById(id);
    }
}
