package com.restap.carshop.controller;

import com.restap.carshop.domain.User;
import com.restap.carshop.dto.UserDto;
import com.restap.carshop.exception.UserException;
import com.restap.carshop.mapper.UserMapper;
import com.restap.carshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody final UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam final Long id) throws UserException {
        if (userService.getUserById(id).isPresent()) {
            userService.deleteUser(id);
        } else {
            throw new UserException();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        List<User> users = userService.getAllUsers();
        return userMapper.mapToUserDtoList(users);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDto getUserById(@RequestParam final Long id) throws UserException {
        return userMapper.mapToUserDto(userService.getUserById(id).orElseThrow(UserException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserByPESEL")
    public UserDto getUserById(@RequestParam final String pesel) throws UserException {
        return userMapper.mapToUserDto(userService.getUserByPESEL(pesel).orElseThrow(UserException::new));
    }
}
