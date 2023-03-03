package com.restap.carshop.domain;

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
public class EngineTestSuite {

    @Autowired
    private EngineRepository engineRepository;

    @Test
    public void addEngineTest() {
        //Given
        Engine engine = new Engine("Type", 354, 99.99);

        //When
        engineRepository.save(engine);
        Long id = engine.getId();
        Optional<Engine> engineTest = engineRepository.findById(id);

        //Then
        assertTrue(engineTest.isPresent());
        assertNotNull(id);

        //Clean Up
        engineRepository.deleteById(id);
    }
}
