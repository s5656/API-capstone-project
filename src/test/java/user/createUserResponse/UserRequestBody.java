package user.createUserResponse;

import java.util.UUID;


public class UserRequestBody {
    private String firstName;
    private String lastName;
    private String title;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

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

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getTitle() {
            return title;
        }

        public String getEmail() {
            return email;
        }

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
