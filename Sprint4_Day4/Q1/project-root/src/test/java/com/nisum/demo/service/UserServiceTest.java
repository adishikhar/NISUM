package com.nisum.demo.service;



import com.nisum.demo.email.EmailSender;
import com.nisum.demo.model.User;
import com.nisum.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailSender emailSender;

    @InjectMocks
    UserService userService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Captor
    ArgumentCaptor<String> subjectCaptor;

    @Test
    void processUser_shouldHandleMissingAndSendEmail() {
        User user = new User("john@example.com");

        when(userRepository.findById(anyLong())).thenReturn(null, user);


        assertThrows(RuntimeException.class, () -> userService.processUser(1L));


        userService.processUser(1L);

        verify(emailSender).send(userCaptor.capture(), subjectCaptor.capture());

        assertEquals("john@example.com", userCaptor.getValue().getEmail());
        assertEquals("Welcome Back", subjectCaptor.getValue());
    }
}

