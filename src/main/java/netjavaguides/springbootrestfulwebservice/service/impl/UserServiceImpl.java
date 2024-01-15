package netjavaguides.springbootrestfulwebservice.service.impl;

import lombok.AllArgsConstructor;
import netjavaguides.springbootrestfulwebservice.dto.UserDto;
import netjavaguides.springbootrestfulwebservice.entity.User;
import netjavaguides.springbootrestfulwebservice.exception.EmailExistException;
import netjavaguides.springbootrestfulwebservice.exception.ResourceNotFoundException;
import netjavaguides.springbootrestfulwebservice.mapper.UserMapper;
import netjavaguides.springbootrestfulwebservice.repository.UserRepository;
import netjavaguides.springbootrestfulwebservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
           throw new EmailExistException("Email Already Exist for User");
        }
        //Convert userDto to jpa entity
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        //Convert jpa to UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(user);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User user =userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","id",id)
        );

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User oldUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", user.getId())
        );
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(oldUser));
    }

    @Override
    public void deleteUser(Long id) {

        User oldUser = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", id  )
        );userRepository.deleteById(id);
    }
}
