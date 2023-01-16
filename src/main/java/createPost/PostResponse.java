package createPost;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;
@Getter
public class PostResponse {
    @Setter
    private int statusCode;
    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private String likes;
    private List<String> tags;

    @Getter
    public static class Owner {
        private String firstName;
        private String title;
        private String lastName;
        private String picture;
        private String id;
    }

    public void assertPostCreate(PostRequestBody requestBody)
    {
        Assert.assertEquals(this.getStatusCode(),200);
        Assert.assertEquals(this.getOwner().getId(),requestBody.getOwner());
    }



}