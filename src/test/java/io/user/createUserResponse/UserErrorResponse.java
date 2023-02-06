package io.user.createUserResponse;


import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

public class UserErrorResponse {
    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    private int statuscode;

    public int getStatuscode() {
        return statuscode;
    }

    public Data getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    private Data data;
    private String error;


    public static class Data {
        public String getEmail() {
            return email;
        }

        public String getMessage() {
            return message;
        }

        private String email;
        private String message;

    }

    public void assertUserErrorData(UserRequestBody requestBody) {
        Assert.assertEquals(this.getStatuscode(), 400);
        Assert.assertEquals(this.getError(), "BODY_NOT_VALID");
        Assert.assertEquals(this.getData().getEmail(), "Email already used");

    }

}
