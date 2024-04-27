package edu.miu.cs.cs489.aerotran.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs489.aerotran.dto.UserDto;
import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private  UserController userController;


    private final ObjectMapper objectMapper = new ObjectMapper();



    @Test
    public void testSaveUser() throws Exception {
        // Mock data
        UserDto userDto = new UserDto("john_doe", "password123", "john@example.com", "1234567890");

        // Call the controller method
        ResponseEntity<?> responseEntity = userController.saveUser(userDto);

        // Verify userService.saveUser(userDto) is called exactly once
        verify(userService, times(1)).saveUser(userDto);

        // Assert response status code is HttpStatus.CREATED (201)
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Mock data
        Long userId = 1L;
        UserDto userDto = new UserDto("john_doe", "password123", "john@example.com", "1234567890");

        // Call the controller method
        ResponseEntity<?> responseEntity = userController.updateUser(userId, userDto);

        // Verify userService.updateUser(userDto) is called exactly once
        verify(userService, times(1)).updateUser(userDto);

        // Assert response status code is HttpStatus.OK (200)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetUser() {
        // Mock data
        Long userId = 1L;
        User user = new User(userId, "john_doe", "password123", "john@example.com", "1234567890");

        // Stub userService.getUserById(userId) to return the mock user
        when(userService.getUserById(userId)).thenReturn(user);

        // Call the controller method
        ResponseEntity<?> responseEntity = userController.getUser(userId);

        // Verify userService.getUserById(userId) is called exactly once
        verify(userService, times(1)).getUserById(userId);

        // Assert response status code is HttpStatus.OK (200)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Assert response body contains the user object
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void testGetAllUser() {
        // Mock data
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "john_doe", "password123", "john@example.com", "1234567890"));
        userList.add(new User(2L, "jane_doe", "password456", "jane@example.com", "9876543210"));

        // Stub userService.getAllUser() to return the mock user list
        when(userService.getAllUser()).thenReturn(userList);

        // Call the controller method
        ResponseEntity<?> responseEntity = userController.getAllUser();

        // Verify userService.getAllUser() is called exactly once
        verify(userService, times(1)).getAllUser();

        // Assert response status code is HttpStatus.OK (200)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Assert response body contains the user list
        assertEquals(userList, responseEntity.getBody());
    }

    @Test
    public void testDeleteUser() {
        // Mock data
        Long userId = 1L;

        // Call the controller method
        ResponseEntity<?> responseEntity = userController.deleteUser(userId);

        // Verify userService.deleteByUserId(userId) is called exactly once
        verify(userService, times(1)).deleteByUserId(userId);

        // Assert response status code is HttpStatus.OK (200)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}