package endtoEndTest;

import post.getPostResponse.GetPostResponse;
import user.createUserResponse.UserRequestBody;
import user.createUserResponse.UserResponse;
import user.getUserRespoonse.GetUserResponse;
import user.userServiceClasses.UserService;
import post.createPostResponse.PostRequestBody;
import post.createPostResponse.PostResponse;
import post.deletePostResponse.DeletePostResponse;
import post.postServiceClasses.PostService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class IntegrationTests {
    PostService postService;
    UserService userService;
    PostResponse postResponse;

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
        userService = new UserService();
    }

    @Test
    public void shouldCreateAndGetPostDetails() throws IOException {
        //Arrange
        PostRequestBody postRequestBody = new PostRequestBody.Builder().build();
        postResponse = postService.createPostResponse(postRequestBody);
        //Act
        GetPostResponse getPostResponse = postService.getPostResponse(postResponse.getId());
        //Assert
        postResponse.assertPostCreate(postRequestBody);
        Assert.assertEquals(getPostResponse.getStatusCode(), 200);
    }
    @Test
    public void shouldDeleteThePost() throws IOException {
        //Act
        DeletePostResponse deletePostResponse = postService.deletePostById(postResponse.getId());
        //Assert
        Assert.assertEquals(deletePostResponse.getStatusCode(), 200);
    }
    @Test
    public void shouldCreateAndGetUserDetails() throws IOException {
        //Arrange
        String queryParamName = "limit";
        int queryParamValue = 10;
        UserRequestBody userRequestBody = new UserRequestBody.Builder().build();
        //Act
        UserResponse userResponse = userService.userResponse(userRequestBody);

        GetUserResponse getUserResponse = userService.getUserResponse(queryParamName, queryParamValue);

        //Assert
        userResponse.assertUser(userRequestBody);
        Assert.assertEquals(getUserResponse.getDataList().size(), 10);
    }
}
