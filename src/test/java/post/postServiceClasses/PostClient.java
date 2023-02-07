package post.postServiceClasses;

import io.restassured.specification.RequestSpecification;
import post.createPostResponse.PostRequestBody;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import properties.GetDataProperty;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostClient {
    GetDataProperty getDataProperty=new GetDataProperty();
    private RequestSpecification getSpecification() throws IOException {
        return RestAssured.given()
                .header("app-id", getDataProperty.getValueProperty("app-id"));
    }
    public Response create(PostRequestBody body) throws IOException {
        Response response = getSpecification()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post(getDataProperty.getValueProperty("base-url")+"post/create");
        response.then().log().body();
        return response;
    }

    public Response get(String postId) throws IOException {
        Response response = getSpecification()
                .when()
                .pathParam("post_id", postId)
                .filter(new AllureRestAssured())
                .get(getDataProperty.getValueProperty("base-url")+"post/{post_id}");
        response.then()
                .log()
                .body();
        return response;
    }

    public Response delete(String deleteId) throws IOException {
        Response response = getSpecification()
                .when()
                .pathParam("post_id", deleteId)
                .filter(new AllureRestAssured())
                .delete(getDataProperty.getValueProperty("base-url")+"post/{post_id}");
        response.then()
                .log()
                .body();
        return response;
    }
}
