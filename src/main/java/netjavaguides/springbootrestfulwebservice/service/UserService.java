package netjavaguides.springbootrestfulwebservice.service;

import netjavaguides.springbootrestfulwebservice.dto.UserDto;
import netjavaguides.springbootrestfulwebservice.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long id);
}
