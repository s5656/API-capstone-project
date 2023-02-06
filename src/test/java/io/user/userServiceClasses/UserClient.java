package io.user.userServiceClasses;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.user.createUserResponse.UserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response create(UserRequestBody body) {
        Response response = RestAssured.given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post("https://dummyapi.io/data/v1/user/create");
        response.then().log().body();
        return response;
    }

    public Response getAll(String queryParamName, int queryParamValue) {
        Response response = RestAssured.given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .queryParam(queryParamName, queryParamValue)
                .when()
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/user?created=1");
        response.then().log().body();
        return response;
    }
}
