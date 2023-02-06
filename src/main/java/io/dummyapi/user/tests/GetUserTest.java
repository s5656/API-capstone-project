package io.dummyapi.user.tests;

import io.dummyapi.user.getUserRespoonse.GetUserResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.user.userServiceClasses.UserService;

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
    }
}
