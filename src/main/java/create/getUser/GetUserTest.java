package create.getUser;

import create.getUser.respoonse.GetUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import create.userServiceClasses.UserService;

public class GetUserTest {
    private UserService userService;
    @BeforeClass
    public void beforeClass(){
        userService=new UserService();
    }
    @Test
    public void shoudGetUserDetails(){
        GetUserResponse getUserResponse=userService.getUserResponse();

        Assert.assertEquals(getUserResponse.getStatusCode(),200);
        Assert.assertEquals(getUserResponse.getDataList().size(),12);
    }
}
