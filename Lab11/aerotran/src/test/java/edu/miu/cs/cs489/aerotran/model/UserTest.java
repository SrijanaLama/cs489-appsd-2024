package edu.miu.cs.cs489.aerotran.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {


    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testUser", "password123", "test@example.com", "1234567890");
    }

    @Test
    public void testUserInitialization() {
        assertNotNull(user);
        assertEquals("testUser", user.getUserName());
        assertEquals("password123", user.getPassword());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertNotNull(user.getUserRoles());
        assertTrue(user.getUserRoles().isEmpty());
    }

    @Test
    public void testCopyUser() {
        user.copy("newUserName", "new@example.com", "9876543210");
        assertEquals("newUserName", user.getUserName());
        assertEquals("new@example.com", user.getEmail());
        assertEquals("9876543210", user.getPhoneNumber());
    }

    @Test
    public void testToString() {
        String expectedToString = "User{" +
                "userId=null" +
                ", userName='testUser'" +
                ", password='password123'" +
                ", email='test@example.com'" +
                ", phoneNumber='1234567890'" +
                ", userRoles=[]" +
                '}';
        assertEquals(expectedToString, user.toString());
    }
}
