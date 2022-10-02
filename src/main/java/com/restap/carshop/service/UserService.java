package com.restap.carshop.service;

import com.restap.carshop.domain.User;
import com.restap.carshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(final User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByPESEL(final String pesel) {
        return userRepository.findByPesel(pesel);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
