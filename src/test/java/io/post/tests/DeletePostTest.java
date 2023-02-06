package io.post.tests;

import io.post.createPostResponse.PostRequestBody;
import io.post.deletePostResponse.DeletePostResponse;
import io.post.postServiceClasses.PostService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostTest {
    private PostService postService;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
    }

    @Test
    public void shouldDeletePostDetailsById() {
        PostRequestBody requestBody = new PostRequestBody.Builder().build();
        String deleteId = postService.createPostResponse(requestBody).getId();
        DeletePostResponse deletePostResponse = postService.deletePostById(deleteId);

        Assert.assertEquals(deletePostResponse.getStatusCode(), 200);
        Assert.assertEquals(deletePostResponse.getId(), deleteId);
    }
}