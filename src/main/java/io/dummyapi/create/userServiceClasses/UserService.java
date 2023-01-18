package io.dummyapi.create.userServiceClasses;

import io.dummyapi.create.createUser.response.UserErrorResponse;
import io.dummyapi.create.createUser.response.UserRequestBody;
import io.dummyapi.create.createUser.response.UserResponse;
import io.dummyapi.create.getUser.respoonse.GetUserResponse;
import io.restassured.response.Response;

public class UserService {
    public UserResponse userResponse(UserRequestBody requestBody){
        Response response = new UserClient().create(requestBody);
        UserResponse userResponse=response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;
    }
    public UserErrorResponse createUserExpectingError (UserRequestBody body){
        Response response =  new UserClient().create(body);
        UserErrorResponse errorResponse = response.as(UserErrorResponse.class);
        errorResponse.setStatuscode(response.statusCode());
        return errorResponse;
    }
    public GetUserResponse getUserResponse(){
        Response response=new UserClient().get();

        GetUserResponse getUser = response.as(GetUserResponse.class);
        getUser.setStatusCode(response.statusCode());
        return getUser;
    }
}
