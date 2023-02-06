package io.dummyapi.post.tests;

import io.dummyapi.post.createPostResponse.PostRequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.post.getPostResponse.GetPostResponse;
import io.dummyapi.post.postServiceClasses.PostService;
public class GetPostTest {
    private PostService postService;
    @BeforeClass
    public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void shouldGetPostDetailsById(){
        PostRequestBody requestBody=new PostRequestBody.Builder().build();
        String getId = postService.createPostResponse(requestBody).getId();
        GetPostResponse getPostResponse = postService.getPostResponse(getId);

        Assert.assertEquals(getPostResponse.getStatusCode(),200);
        Assert.assertEquals(getPostResponse.getId(),getId);

    }
}

