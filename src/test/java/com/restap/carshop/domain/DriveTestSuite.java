package com.restap.carshop.domain;

import com.restap.carshop.repository.DriveRepository;
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
public class DriveTestSuite {

    @Autowired
    private DriveRepository driveRepository;

    @Test
    public void addDriveTest() {
        //Given
        Drive drive = new Drive("Drive", 99.99);

        //When
        driveRepository.save(drive);
        Long id = drive.getId();
        Optional<Drive> testDrive = driveRepository.findById(id);

        //Then
        assertTrue(testDrive.isPresent());
        assertNotNull(id);

        //Clean Up
        driveRepository.deleteById(id);
    }
}
