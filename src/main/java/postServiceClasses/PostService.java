package postServiceClasses;

import createPost.PostRequestBody;
import createPost.PostResponse;
import deletePost.DeletePostResponse;
import getPost.GetPostResponse;
import io.restassured.response.Response;

public class PostService {
    public PostResponse createPostResponse(PostRequestBody requestBody){
        Response response = new PostClass().create(requestBody);
        PostResponse postResponse=response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;

    }
    public GetPostResponse getPostResponse(String postId){
        Response response=new PostClass().get(postId);
        int statusCode = response.statusCode();
        GetPostResponse getPostResponse = response.as(GetPostResponse.class);
        getPostResponse.setStatusCode(statusCode);

        return getPostResponse ;
    }
    public DeletePostResponse deletePostById(String deletePostId)
    {
        Response response = new PostClass().delete(deletePostId);
        int statusCode =   response.statusCode();
        DeletePostResponse deletePostResponse = response.as(DeletePostResponse.class);
        deletePostResponse.setStatusCode(statusCode);
        return deletePostResponse;

    }
}
