package postServiceClasses;

import createPost.PostRequestBody;
import createUser.UserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClass {
    public Response create(PostRequestBody body) {
        Response response = given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
        response.then().log().body();
        return response;
    }

    public Response get(String postId) {
        Response response=given()
                .header("app-id", "63bfea5ba39ed71aa088d9a7")
                .when()
                .pathParam("post_id",postId)
                .get("https://dummyapi.io/data/v1/post/{post_id}");
        response.then()
                .log()
                .body();
        return response;
    }
}
