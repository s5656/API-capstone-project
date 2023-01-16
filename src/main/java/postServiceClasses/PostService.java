package postServiceClasses;

import createPost.PostRequestBody;
import createPost.PostResponse;
import io.restassured.response.Response;

public class PostService {
    public PostResponse createPostResponse(PostRequestBody requestBody){
        Response response = new PostClass().create(requestBody);
        PostResponse postResponse=response.as(PostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;

    }
}
