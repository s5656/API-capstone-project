package io.endtoEndTest;

import io.post.getPostResponse.GetPostResponse;
import io.user.createUserResponse.UserRequestBody;
import io.user.createUserResponse.UserResponse;
import io.user.getUserRespoonse.GetUserResponse;
import io.user.userServiceClasses.UserService;
import io.post.createPostResponse.PostRequestBody;
import io.post.createPostResponse.PostResponse;
import io.post.deletePostResponse.DeletePostResponse;
import io.post.postServiceClasses.PostService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IntegrationTests {
    PostService postService;
    UserService userService;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
        userService = new UserService();
    }

    @Test
    public void shouldCreateGetAndDeletePostAndUser() {
        //Arrange
        String queryParamName = "limit";
        int queryParamValue = 10;
        UserRequestBody userRequestBody = new UserRequestBody.Builder().build();
        UserResponse userResponse = userService.userResponse(userRequestBody);
        //act
        PostRequestBody postRequestBody = new PostRequestBody.Builder().build();
        PostResponse postResponse = postService.createPostResponse(postRequestBody);

        GetPostResponse getPostResponse = postService.getPostResponse(postResponse.getId());
        DeletePostResponse deletePostResponse = postService.deletePostById(postResponse.getId());

        GetUserResponse getUserResponse = userService.getUserResponse(queryParamName, queryParamValue);

        //Assert
        userResponse.assertUser(userRequestBody);
        postResponse.assertPostCreate(postRequestBody);
        Assert.assertEquals(getPostResponse.getStatusCode(), 200);
        Assert.assertEquals(deletePostResponse.getStatusCode(), 200);
        Assert.assertEquals(getUserResponse.getDataList().size(), 10);
    }
}