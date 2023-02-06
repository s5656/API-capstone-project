package io.user.userServiceClasses;

import io.user.createUserResponse.UserErrorResponse;
import io.user.createUserResponse.UserRequestBody;
import io.user.createUserResponse.UserResponse;
import io.user.getUserRespoonse.GetUserResponse;
import io.restassured.response.Response;

public class UserService {
    public UserResponse userResponse(UserRequestBody requestBody) {
        Response response = new UserClient().create(requestBody);
        UserResponse userResponse = response.as(UserResponse.class);
        userResponse.setStatusCode(response.statusCode());
        return userResponse;
    }

    public UserErrorResponse createUserExpectingError(UserRequestBody body) {
        Response response = new UserClient().create(body);
        UserErrorResponse errorResponse = response.as(UserErrorResponse.class);
        errorResponse.setStatuscode(response.statusCode());
        return errorResponse;
    }

    public GetUserResponse getUserResponse(String queryParamName, int queryParamValue) {
        Response response = new UserClient().getAll(queryParamName, queryParamValue);

        GetUserResponse getUser = response.as(GetUserResponse.class);
        getUser.setStatusCode(response.statusCode());
        return getUser;
    }
}