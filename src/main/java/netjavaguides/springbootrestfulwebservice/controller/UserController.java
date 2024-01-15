package netjavaguides.springbootrestfulwebservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import netjavaguides.springbootrestfulwebservice.dto.UserDto;
import netjavaguides.springbootrestfulwebservice.entity.User;
import netjavaguides.springbootrestfulwebservice.exception.ErrorDetails;
import netjavaguides.springbootrestfulwebservice.exception.ResourceNotFoundException;
import netjavaguides.springbootrestfulwebservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD APIs",
        description = "Create user, update, get , getAll"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    //build create User REST API
    @Operation(
            summary = "Create user API",
            description = "Create new users"
    )
    @ApiResponse(
             responseCode = "201"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get user API",
            description = "Find users"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all user API",
            description = "Find all users"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto user){
        user.setId(id);
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted successfully!",HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException e, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(), e.getMessage(), webRequest.getDescription(false),"USER_NOT_FOUND"
//            );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//
//    }

}
