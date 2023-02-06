package io.dummyapi.user.tests;

import io.dummyapi.user.createUserResponse.UserRequestBody;
import io.dummyapi.user.createUserResponse.UserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.user.userServiceClasses.UserService;

public class CreateUserTest {
    private UserService userService;
    @BeforeClass
    public void beforeClass(){
        userService=new UserService();
    }
    @Test
    public void shouldCreateAnUser(){
        //Arrange
        UserRequestBody userRequest=new UserRequestBody.Builder().build();
        //Act
        UserResponse userResponse = userService.userResponse(userRequest);
        //Assert
        userResponse.assertUser(userRequest);
    }
}
