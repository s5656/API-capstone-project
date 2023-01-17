package post.integration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import post.createPost.response.PostRequestBody;
import post.createPost.response.PostResponse;
import post.deletePost.response.DeletePostResponse;
import post.postServiceClasses.PostService;

public class IntegrationTests {
    PostService postService;
    PostResponse postResponse;
    @BeforeClass
     public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void createThePost(){
        PostRequestBody requestBody=new PostRequestBody.Builder().build();
        postResponse=postService.createPostResponse(requestBody);
        int statusCodeCreatePost=postResponse.getStatusCode();

        Assert.assertEquals(statusCodeCreatePost,200);
    }
    @Test
    public void deleteThePost(){
        DeletePostResponse deletePostResponse=postService.deletePostById(postResponse.getId());
        int statusCodeDeletePost=deletePostResponse.getStatusCode();
        Assert.assertEquals(statusCodeDeletePost,200);
    }
}
