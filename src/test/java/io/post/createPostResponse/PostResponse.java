package io.post.createPostResponse;
import org.testng.Assert;

import java.util.List;


public class PostResponse {

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private int statusCode;
    private Owner owner;

    public int getStatusCode() {
        return statusCode;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getLikes() {
        return likes;
    }

    public List<String> getTags() {
        return tags;
    }

    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String updatedDate;
    private String likes;
    private List<String> tags;


    public static class Owner {
        private String firstName;
        private String title;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getTitle() {
            return title;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPicture() {
            return picture;
        }

        public String getId() {
            return id;
        }

        private String picture;
        private String id;
    }

    public void assertPostCreate(PostRequestBody requestBody) {
        Assert.assertEquals(this.getStatusCode(), 200);
        Assert.assertEquals(this.getOwner().getId(), requestBody.getOwner());
    }

}