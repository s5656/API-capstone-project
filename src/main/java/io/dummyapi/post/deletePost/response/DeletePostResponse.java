package io.dummyapi.post.deletePost.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DeletePostResponse {
    @Setter
    private int statusCode;
    private String id;
}
