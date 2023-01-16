package createUser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import userServiceClasses.UserService;

public class CreateUserErrorTest {
    private UserService userService;
    @BeforeClass
    public void beforeClass(){
        userService=new UserService();
    }
    @Test
    public void shoudNotAllowInvalidEmail(){
        UserRequestBody userRequest=new UserRequestBody.Builder().email("SaraAndersen@gmailj.com").build();
        UserErrorResponse userErrorResponse = userService.createUserExpectingError(userRequest);
        Assert.assertEquals(userErrorResponse.getStatuscode(),400);
        userErrorResponse.assertUserErrorData(userRequest);
    }
}
