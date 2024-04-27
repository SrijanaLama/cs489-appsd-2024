package edu.miu.cs.cs489.aerotran.repository;

import edu.miu.cs.cs489.aerotran.model.User;
import edu.miu.cs.cs489.aerotran.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;



    @Test
    public void testFindByUserId_UserFound() {
        // Mock data
        Long userId = 1L;
        User user = new User(userId, "john_doe", "password123", "john@example.com", "1234567890");

        // Stub userRepository.findByUserId(userId) to return Optional.of(user) when called with the specified userId
        when(userRepository.findByUserId(userId)).thenReturn(Optional.of(user));

        // Call the repository method
        Optional<User> retrievedUserOptional = userRepository.findByUserId(userId);

        // Verify userRepository.findByUserId(userId) is called exactly once with the specified userId
        verify(userRepository, times(1)).findByUserId(userId);

        // Assert that the retrievedUserOptional contains the expected user
        assertEquals(user, retrievedUserOptional.orElse(null)); // Compare retrieved user with expected user
    }

    @Test
    public void testFindByUserId_UserNotFound() {
        // Mock data
        Long userId = 2L;

        // Stub userRepository.findByUserId(userId) to return Optional.empty() when called with the specified userId
        when(userRepository.findByUserId(userId)).thenReturn(Optional.empty());

        // Call the repository method
        Optional<User> retrievedUserOptional = userRepository.findByUserId(userId);

        // Verify userRepository.findByUserId(userId) is called exactly once with the specified userId
        verify(userRepository, times(1)).findByUserId(userId);

        // Assert that the retrievedUserOptional is empty
        assertEquals(Optional.empty(), retrievedUserOptional); // Ensure retrieved user is empty
    }
}
