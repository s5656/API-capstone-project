package io;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.post.getPost.response.GetPostResponse;
import io.dummyapi.post.postServiceClasses.PostService;
public class GetPostTest {
    private PostService postService;
    @BeforeClass
    public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void shoudGetPostDetails(){
        String postId = "60d21b7f67d0d8992e610d2b";
        GetPostResponse getPostResponse=postService.getPostResponse(postId);
        Assert.assertEquals(getPostResponse.getStatusCode(),200);
        Assert.assertEquals(getPostResponse.getId(),postId);

    }
}

