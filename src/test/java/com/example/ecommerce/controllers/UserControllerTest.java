package com.example.ecommerce.controllers;

import com.example.ecommerce.TestUtils;
import com.example.ecommerce.model.persistence.User;
import com.example.ecommerce.model.persistence.repositories.CartRepository;
import com.example.ecommerce.model.persistence.repositories.UserRepository;
import com.example.ecommerce.model.requests.CreateUserRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    private UserController userController;

    private UserRepository userRepository = mock(UserRepository.class);

    private CartRepository cartRepository = mock(CartRepository.class);

    private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);


    @Before
    public void setUp() {
        userController = new UserController();
        TestUtils.injectObjects(userController, "userRepository",userRepository);
        TestUtils.injectObjects(userController, "cartRepository",cartRepository);
        TestUtils.injectObjects(userController, "bCryptPasswordEncoder",encoder);
    }

    @Test
    public void create_user_happy_path() throws Exception{
        when(encoder.encode("testPassword")).thenReturn("thisIsHashed");

        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("test");
        request.setPassword("testPassword");
        request.setConfirmPassword("testPassword");

        final ResponseEntity<User> response = userController.createUser(request);

        Assert.assertNotNull(response);
        Assert.assertEquals(200, response.getStatusCodeValue());

        User user = response.getBody();

        Assert.assertNotNull(user);
        Assert.assertEquals(0,user.getId());
        Assert.assertEquals("test",user.getUsername());
        Assert.assertEquals("thisIsHashed",user.getPassword());

    }




}
