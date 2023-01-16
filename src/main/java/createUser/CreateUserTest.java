package createUser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import userServiceClasses.UserService;

public class CreateUserTest {
    private UserService userService;
    @BeforeClass
    public void beforeClass(){
        userService=new UserService();
    }
    @Test
    public void shoudCreateNewUser(){
        UserRequestBody userRequest=new UserRequestBody.Builder().build();
        UserResponse userResponse = userService.userResponse(userRequest);
        userResponse.assertUser(userRequest);
    }
}
