package io.post.postServiceClasses;

import io.post.createPostResponse.PostRequestBody;
import io.post.createPostResponse.PostResponse;
import io.post.deletePostResponse.DeletePostResponse;
import io.post.getPostResponse.GetPostResponse;
import io.restassured.response.Response;

public class PostService {
    public PostResponse createPostResponse(PostRequestBody requestBody) {
        Response response = new PostClient().create(requestBody);
        PostResponse postResponse = response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;

    }

    public GetPostResponse getPostResponse(String postId) {
        Response response = new PostClient().get(postId);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse;
    }

    public DeletePostResponse deletePostById(String deletePostId) {
        Response response = new PostClient().delete(deletePostId);
        int statusCode = response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);
        return deletePostResponse;

    }
}
