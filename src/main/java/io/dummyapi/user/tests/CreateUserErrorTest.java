package io.dummyapi.user.tests;

import io.dummyapi.user.createUserResponse.UserErrorResponse;
import io.dummyapi.user.createUserResponse.UserRequestBody;
import io.dummyapi.user.createUserResponse.UserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.user.userServiceClasses.UserService;

public class CreateUserErrorTest {
    private UserService userService;

    @BeforeClass
    public void beforeClass() {
        userService = new UserService();
    }

    @Test
    public void shouldNotAllowUserWithInvalidEmail() {
        //Arrange
        UserRequestBody userRequest = new UserRequestBody.Builder().build();
        userService.userResponse(userRequest);
        //act
        UserErrorResponse userErrorResponse = userService.createUserExpectingError(userRequest);
        //assert
        userErrorResponse.assertUserErrorData(userRequest);
    }
}
