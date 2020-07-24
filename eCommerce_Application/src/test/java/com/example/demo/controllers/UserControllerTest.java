package com.example.demo.controllers;

import com.example.demo.TestUtils;
import com.example.demo.model.persistence.User;
import com.example.demo.model.persistence.repositories.CartRepository;
import com.example.demo.model.persistence.repositories.UserRepository;
import com.example.demo.model.requests.CreateUserRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    private UserController userController;
    private UserRepository userRepository = mock(UserRepository.class);
    private CartRepository cartRepository = mock(CartRepository.class);
    private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);

    public static void pass() {}

    @Before
    public void setUp() {
        userController = new UserController();
        TestUtils.injectObjects(userController, "userRepository", userRepository);
        TestUtils.injectObjects(userController, "cartRepository", cartRepository);
        TestUtils.injectObjects(userController, "bCryptPasswordEncoder", encoder);
    }
    @Test
    public void create_user_happy_path() throws Exception {
        /* Hashing */
        when(encoder.encode("not_unique_password")).thenReturn("IamHandsome");

        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUsername("unique_username");
        userRequest.setPassword("not_unique_password");
        userRequest.setConfirmPassword("not_unique_password");

        final ResponseEntity<User> responseEntity = userController.createUser(userRequest);
        /* Unit test */
        assertNotNull (responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());

        User user = responseEntity.getBody();
        assertNotNull(user);
        assertEquals(0, user.getId());
        assertEquals("unique_username", user.getUsername());
        assertEquals("IamHandsome", user.getPassword());
    }
}
