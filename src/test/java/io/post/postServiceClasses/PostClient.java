package io.post.postServiceClasses;

import io.post.createPostResponse.PostRequestBody;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClient {
    public Response create(PostRequestBody body) {
        Response response = RestAssured.given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .filter(new AllureRestAssured())
                .post("https://dummyapi.io/data/v1/post/create");
        response.then().log().body();
        return response;
    }

    public Response get(String postId) {
        Response response = RestAssured.given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .when()
                .pathParam("post_id", postId)
                .filter(new AllureRestAssured())
                .get("https://dummyapi.io/data/v1/post/{post_id}");
        response.then()
                .log()
                .body();
        return response;
    }

    public Response delete(String deleteId) {
        Response response = RestAssured.given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .when()
                .pathParam("post_id", deleteId)
                .filter(new AllureRestAssured())
                .delete("https://dummyapi.io/data/v1/post/{post_id}");
        response.then()
                .log()
                .body();
        return response;
    }
}
