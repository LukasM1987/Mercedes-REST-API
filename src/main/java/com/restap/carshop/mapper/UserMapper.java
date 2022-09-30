package com.restap.carshop.mapper;

import com.restap.carshop.domain.User;
import com.restap.carshop.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getPesel(),
                userDto.getName(),
                userDto.getSecondName(),
                userDto.getCity(),
                userDto.getStreet(),
                userDto.getHouse(),
                userDto.getLocal());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getId(),
                user.getPesel(),
                user.getName(),
                user.getSecondName(),
                user.getCity(),
                user.getStreet(),
                user.getHouse(),
                user.getLocal());
    }

    public List<UserDto> mapToUserDtoList(final List<User> users) {
        return users.stream().map(this::mapToUserDto).collect(Collectors.toList());
    }
}
