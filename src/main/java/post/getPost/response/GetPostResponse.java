package post.getPost.response;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GetPostResponse {
    @Setter
    private int statusCode;
    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String likes;
    private String[] tags;


    @Getter
    public class Owner {
        private String firstName;
        private String lastName;
        private String id;
        private String title;
        private String picture;
    }
}
