package io;

import io.dummyapi.create.createUser.response.UserRequestBody;
import io.dummyapi.create.createUser.response.UserResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.create.userServiceClasses.UserService;

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
