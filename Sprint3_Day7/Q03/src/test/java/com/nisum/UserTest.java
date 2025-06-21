package com.nisum;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserFields() {
        User user = new User("Aditya", "aditya@gmail.com", 25);

        assertAll("User Fields",
                () -> assertEquals("Aditya", user.getName()),
                () -> assertEquals("aditya@gmail.com", user.getEmail()),
                () -> assertEquals(25, user.getAge())
        );

        assertTrue(user.getAge() > 18);
        assertNotNull(user.getEmail());
    }

    @Test
    void testValidateAgeThrowsException() {
        UserService service = new UserService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.validateAge(15);
        });

        assertEquals("Underage", exception.getMessage());
    }
}

