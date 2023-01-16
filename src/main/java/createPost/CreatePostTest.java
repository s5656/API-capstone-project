package createPost;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postServiceClasses.PostService;

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

