package post.getPostResponse;


public class GetPostResponse {
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private int statusCode;

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

    public String getLikes() {
        return likes;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String[] getTags() {
        return tags;
    }

    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String id;
    private String text;
    private String likes;
    private String updatedDate;
    private String[] tags;


    public class Owner {
        private String firstName;

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

        public String getPicture() {
            return picture;
        }

        private String lastName;
        private String id;
        private String title;
        private String picture;
    }
}
