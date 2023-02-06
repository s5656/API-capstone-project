package io.dummyapi.post.createPostResponse;

import lombok.Getter;

import java.util.List;

@Getter
public class PostRequestBody {
    private String owner;
    private String image;
    private String text;
    private List<String> tags;

    public PostRequestBody(Builder builder) {
        this.image = builder.image;
        this.owner = builder.owner;
        this.tags = builder.tags;
        this.text = builder.text;
    }

    @Getter
    public static class Builder {
        private String owner;
        private String image;
        private String text;
        private List<String> tags;

        public Builder() {
            this.image = "https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg";
            this.tags = List.of("animal",
                    "dog",
                    "golden retriever");
            this.owner = "63da5a502bea7749fb67bc7a";
            this.text = "adult Labrador retriever";
        }

        public PostRequestBody build() {
            PostRequestBody postRequestBody = new PostRequestBody(this);
            return postRequestBody;
        }
    }
}