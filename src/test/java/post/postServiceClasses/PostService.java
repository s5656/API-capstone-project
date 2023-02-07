package post.postServiceClasses;

import post.createPostResponse.PostRequestBody;
import post.createPostResponse.PostResponse;
import post.deletePostResponse.DeletePostResponse;
import post.getPostResponse.GetPostResponse;
import io.restassured.response.Response;

import java.io.IOException;

public class PostService {
    public PostResponse createPostResponse(PostRequestBody requestBody) throws IOException {
        Response response = new PostClient().create(requestBody);
        PostResponse postResponse = response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;

    }

    public GetPostResponse getPostResponse(String postId) throws IOException {
        Response response = new PostClient().get(postId);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }

    public DeletePostResponse deletePostById(String deletePostId) throws IOException {
        Response response = new PostClient().delete(deletePostId);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);
        return deletePostResponse;

    }
}
