package io.dummyapi.create.userServiceClasses;

import io.dummyapi.create.createUser.response.UserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response create(UserRequestBody body) {
        Response response = given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");
        response.then().log().body();
        return response;
    }
    public Response get(){
        Response response=given()
                .header("app-id","63bfea5ba39ed71aa088d9a7")
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1");
        response.then().log().body();
        return response;
    }
}
