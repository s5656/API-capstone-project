package createUser;

import lombok.Getter;

import java.util.UUID;
@Getter
public class UserRequestBody {
    private String firstName;
    private String lastName;
    private String title;
    private String email;

    public UserRequestBody(Builder builder) {
        this.firstName=builder.firstName;
        this.lastName= builder.lastName;
        this.title= builder.title;
        this.email= builder.email;
    }
    public static class Builder{
        private String firstName;
        private String lastName;
        private String title;
        private String email;

        public Builder(){
            this.firstName="Sara";
            this.lastName="Andersen";
            this.title="ms";
            this.email=String.format("sara%s@gmail.com", UUID.randomUUID());
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public UserRequestBody build(){
            return new UserRequestBody(this);
        }

    }
}
