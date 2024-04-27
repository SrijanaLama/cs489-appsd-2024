package edu.miu.cs.cs489.aerotran.service;

import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.repository.UserRepository;
import edu.miu.cs.cs489.aerotran.service.impl.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

  @InjectMocks
  private  UserService userService = new UserServiceImpl(userRepository);




    @Test
    public void testGetAllUser() {

        User user1 = new User(1L, "user1", "password1", "user1@example.com", "1234567890");
        User user2 = new User(2L, "user2", "password2", "user2@example.com", "9876543210");
        List<User> mockUsers = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(mockUsers);

        UserServiceImpl userService = new UserServiceImpl(userRepository);

        List<User> retrievedUsers = userService.getAllUser();

        verify(userRepository).findAll();

        // Verify the result
        assertEquals(2, retrievedUsers.size()); // Check if the correct number of users is returned
        assertEquals(user1.getUserName(), retrievedUsers.get(0).getUserName()); // Check user details
        assertEquals(user2.getUserName(), retrievedUsers.get(1).getUserName());


    }

    @Test
    public void testGetUserByUserName_UserFound() {
        // Mock data
        String userName = "john_doe";
        User user = new User(1L, userName, "password123", "john@example.com", "1234567890");

        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(user));

        User retrievedUserOptional = userService.getUserByUserName(userName);

        verify(userRepository, times(1)).findByUserName(userName);

        assertEquals(user, retrievedUserOptional); // Compare retrieved user with expected user
    }


    @Test
    public void testGetUserByUserName_UserNotFound() {

        String userName = "non_existing_user";

        when(userRepository.findByUserName(userName)).thenReturn(Optional.empty());

           assertThrows(UsernameNotFoundException.class, () -> {
            userService.getUserByUserName(userName);
        });

        verify(userRepository, times(1)).findByUserName(userName);
    }


}