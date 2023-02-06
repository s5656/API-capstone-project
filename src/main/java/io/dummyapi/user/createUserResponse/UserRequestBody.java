package io.dummyapi.user.createUserResponse;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserRequestBody {
    private String firstName;
    private String lastName;
    private String title;
    private String email;

    public UserRequestBody(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.title = builder.title;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String title;
        private String email;

        public Builder() {
            this.firstName = "Sumit";
            this.lastName = "Chavan";
            this.title = "mr";
            this.email = String.format(UUID.randomUUID() + "@gmail.com");
        }

        public UserRequestBody build() {
            return new UserRequestBody(this);
        }

    }
}
