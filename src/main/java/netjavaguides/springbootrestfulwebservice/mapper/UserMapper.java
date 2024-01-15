package netjavaguides.springbootrestfulwebservice.mapper;

import netjavaguides.springbootrestfulwebservice.dto.UserDto;
import netjavaguides.springbootrestfulwebservice.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        //convert jpa entity to Dto
         UserDto userDto = new UserDto(
                 user.getId(),
                 user.getFirstName(),
                 user.getLastName(),
                 user.getEmail()
         );
         return userDto;
    }

    //convert dto to jpa entity
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
