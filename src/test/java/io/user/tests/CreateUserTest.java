package io.user.tests;

import io.user.createUserResponse.UserRequestBody;
import io.user.createUserResponse.UserResponse;
import io.user.userServiceClasses.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUserTest {
    private UserService userService;

    @BeforeClass
    public void beforeClass() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateAnUser() {
        //Arrange
        UserRequestBody userRequest = new UserRequestBody.Builder().build();
        //Act
        UserResponse userResponse = userService.userResponse(userRequest);
        //Assert
        userResponse.assertUser(userRequest);
    }
}
