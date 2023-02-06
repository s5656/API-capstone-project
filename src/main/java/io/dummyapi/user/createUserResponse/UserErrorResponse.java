package io.dummyapi.user.createUserResponse;


import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;


@Getter
public class UserErrorResponse {
    @Setter
    private int statuscode;
    private Data data;
    private String error;

    @Getter
    public static class Data{
        private String email;
        private String message;

    }
    public void assertUserErrorData(UserRequestBody requestBody) {
        Assert.assertEquals(this.getStatuscode(),400);
        Assert.assertEquals(this.getError(),"BODY_NOT_VALID");
        Assert.assertEquals(this.getData().getEmail(),"Email already used");

    }

}
