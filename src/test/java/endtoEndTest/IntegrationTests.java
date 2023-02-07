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

    @BeforeClass
    public void beforeClass() {
        postService = new PostService();
        userService = new UserService();
    }

    @Test
    public void shouldCreateGetAndDeletePostAndUser() throws IOException {
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
