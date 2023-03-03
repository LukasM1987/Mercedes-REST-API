package com.restap.carshop.domain;

import com.restap.carshop.repository.EngineExemplarRepository;
import com.restap.carshop.repository.EngineRepository;
import com.restap.carshop.repository.ModelExemplarRepository;
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
public class ModelExemplarTestSuite {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelExemplarRepository modelExemplarRepository;

    @Test
    public void addModelExemplarTest() {
        //Given
        Model model = new Model("Car Class", "Type", 99.99);
        ModelExemplar modelExemplar = new ModelExemplar("0000000000", true);

        //When
        modelRepository.save(model);
        modelExemplarRepository.save(modelExemplar);
        model.getModelExemplarList().add(modelExemplar);
        modelExemplar.setModel(model);
        Long id = modelExemplar.getId();
        Optional<ModelExemplar> modelExemplarTest = modelExemplarRepository.findById(id);

        //Then
        assertTrue(modelExemplarTest.isPresent());
        assertNotNull(id);

        //Clean Up
        modelRepository.deleteById(model.getId());
        modelExemplarRepository.deleteById(id);
    }
}
