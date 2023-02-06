package io.dummyapi.post.tests;

import io.dummyapi.post.createPostResponse.PostRequestBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.dummyapi.post.deletePostResponse.DeletePostResponse;
import io.dummyapi.post.postServiceClasses.PostService;

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