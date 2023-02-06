package io.dummyapi.post.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.post.createPostResponse.PostRequestBody;
import io.dummyapi.post.createPostResponse.PostResponse;
import io.dummyapi.post.postServiceClasses.PostService;

public class CreatePostTest {
    private PostService postService;
    @BeforeClass
    public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void shouldCreateNewPost(){
        PostRequestBody postRequest=new PostRequestBody.Builder().build();
        PostResponse postResponse =postService.createPostResponse(postRequest);
        postResponse.assertPostCreate(postRequest);
    }

}

