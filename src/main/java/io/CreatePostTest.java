package io;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.post.createPost.response.PostRequestBody;
import io.dummyapi.post.createPost.response.PostResponse;
import io.dummyapi.post.postServiceClasses.PostService;

public class CreatePostTest {
    private PostService postService;
    @BeforeClass
    public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void shouCreateNewPost(){
        PostRequestBody postRequest=new PostRequestBody.Builder().build();
        PostResponse postResponse =postService.createPostResponse(postRequest);
        postResponse.assertPostCreate(postRequest);
    }

}

