package com.restap.carshop.domain;

import com.restap.carshop.repository.UserRepository;
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
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        //Given
        User user = new User(
                "000000000",
                "Name",
                "Surname",
                "City",
                "Street",
                "House",
                "Local");

        //When
        userRepository.save(user);
        Long id = user.getId();
        Optional<User> testUser = userRepository.findById(id);

        //Then
        assertTrue(testUser.isPresent());
        assertNotNull(id);

        //Clean Up
        userRepository.deleteById(id);
    }
}
