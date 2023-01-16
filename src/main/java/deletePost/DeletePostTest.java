package deletePost;

import getPost.GetPostResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postServiceClasses.PostService;

public class DeletePostTest {
    private PostService postService;
    @BeforeClass
    public void beforeClass(){
        postService=new PostService();
    }
    @Test
    public void shoudDeletePostDetails(){
        String deleteId = "60d21b7f67d0d8992e610d2b";
        DeletePostResponse postResponse = postService.deletePostById(deleteId);
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }
}