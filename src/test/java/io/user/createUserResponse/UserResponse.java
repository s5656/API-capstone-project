package io.user.createUserResponse;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;


public class UserResponse {
    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getEmail() {
        return email;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

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
