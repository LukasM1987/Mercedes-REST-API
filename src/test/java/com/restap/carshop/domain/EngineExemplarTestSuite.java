package com.restap.carshop.domain;

import com.restap.carshop.repository.EngineExemplarRepository;
import com.restap.carshop.repository.EngineRepository;
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
public class EngineExemplarTestSuite {

    @Autowired
    private EngineRepository engineRepository;

    @Autowired
    private EngineExemplarRepository engineExemplarRepository;

    @Test
    public void addEngineExemplarTest() {
        //Given
        Engine engine = new Engine("Type", 354, 99.99);
        EngineExemplar engineExemplar = new EngineExemplar("0000000000", true);

        //When
        engineRepository.save(engine);
        engineExemplarRepository.save(engineExemplar);
        engine.getEngineExemplarList().add(engineExemplar);
        engineExemplar.setEngine(engine);
        Long id = engineExemplar.getId();
        Optional<EngineExemplar> engineExemplarTest = engineExemplarRepository.findById(id);

        //Then
        assertTrue(engineExemplarTest.isPresent());
        assertNotNull(id);

        //Clean Up
        engineRepository.deleteById(engine.getId());
        engineExemplarRepository.deleteById(id);
    }
}
