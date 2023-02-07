package user.userServiceClasses;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import properties.GetDataProperty;
import user.createUserResponse.UserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;


public class UserClient {
    GetDataProperty getDataProperty=new GetDataProperty();
    private RequestSpecification getSpecification() throws IOException {
        return RestAssured.given()
                .header("app-id", getDataProperty.getValueProperty("app-id"));
    }
    public Response create(UserRequestBody body) throws IOException {
        Response response = getSpecification()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post(getDataProperty.getValueProperty("base-url")+"user/create");
        response.then().log().body();
        return response;
    }


    public Response getAll(String queryParamName, int queryParamValue) throws IOException {
        Response response = getSpecification()
                .queryParam(queryParamName, queryParamValue)
                .when()
                .filter(new AllureRestAssured())
                .get(getDataProperty.getValueProperty("base-url")+"user");
        response.then().log().body();
        return response;
    }
}
