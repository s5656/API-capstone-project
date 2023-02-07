package user.tests;

import user.createUserResponse.UserErrorResponse;
import user.createUserResponse.UserRequestBody;
import user.userServiceClasses.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
