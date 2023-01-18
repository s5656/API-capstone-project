package io.dummyapi.create.createUser.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class UserResponse {
    @Setter
    private int statusCode;
    private String firstName;
    private String lastName;
    private String id;
    private String title;
    private String updatedDate;
    private String email;
    private String registerDate;

    public void assertUser(UserRequestBody requestBody) {
        Assert.assertEquals(this.getStatusCode(), 200);
        Assert.assertEquals(this.getEmail(), requestBody.getEmail());
        Assert.assertEquals(this.getFirstName(), requestBody.getFirstName());
        Assert.assertEquals(this.getLastName(), requestBody.getLastName());
    }
}
