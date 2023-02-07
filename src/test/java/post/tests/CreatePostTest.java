package post.tests;

import post.createPostResponse.PostRequestBody;
import post.createPostResponse.PostResponse;
import post.postServiceClasses.PostService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePostTest {
    private PostService postService;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
    }

    @Test
    public void shouldCreateNewPost() {
        PostRequestBody postRequest = new PostRequestBody.Builder().build();
        PostResponse postResponse = postService.createPostResponse(postRequest);
        postResponse.assertPostCreate(postRequest);
    }

}

