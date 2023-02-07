package user.tests;

import user.getUserRespoonse.GetUserResponse;
import user.userServiceClasses.UserService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetUserTest {
    private UserService userService;

    @BeforeClass
    public void beforeClass() {
        userService = new UserService();
    }

    @Test
    public void shouldGetListOfUsersOfGivenLimit() {
        String queryParamName = "limit";
        int queryParamValue = 10;
        GetUserResponse getUserResponse = userService.getUserResponse(queryParamName, queryParamValue);

        Assert.assertEquals(getUserResponse.getStatusCode(), 200);
        Assert.assertEquals(getUserResponse.getLimit(), 10);
        Assert.assertEquals(getUserResponse.getDataList().size(), 10);
        Assert.fail();
    }
}
