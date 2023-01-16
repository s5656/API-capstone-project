package userServiceClasses;

import createUser.UserErrorResponse;
import createUser.UserRequestBody;
import createUser.UserResponse;
import getUser.GetUserResponse;
import io.restassured.response.Response;

public class UserService {
    public UserResponse userResponse(UserRequestBody requestBody){
        Response response = new UserClass().create(requestBody);
        UserResponse userResponse=response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;

    }
    public UserErrorResponse createUserExpectingError (UserRequestBody body){
        Response response =  new UserClass().create(body);
        UserErrorResponse errorResponse = response.as(UserErrorResponse.class);
        errorResponse.setStatuscode(response.statusCode());
        return errorResponse;
    }
    public GetUserResponse getUserResponse(){
        Response response=new UserClass().get();

        GetUserResponse getUser = response.as(GetUserResponse.class);
        getUser.setStatusCode(response.statusCode());
        return getUser;
    }
}
