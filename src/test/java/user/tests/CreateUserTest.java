package user.tests;

import user.createUserResponse.UserRequestBody;
import user.createUserResponse.UserResponse;
import user.userServiceClasses.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateUserTest {
    private UserService userService;

    @BeforeClass
    public void beforeClass() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateAnUser() throws IOException {
        //Arrange
        UserRequestBody userRequest = new UserRequestBody.Builder().build();
        //Act
        UserResponse userResponse = userService.userResponse(userRequest);
        //Assert
        userResponse.assertUser(userRequest);
    }
}
