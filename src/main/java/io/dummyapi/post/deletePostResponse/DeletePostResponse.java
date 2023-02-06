package io.dummyapi.post.deletePostResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DeletePostResponse {
    @Setter
    private int statusCode;
    private String id;
}
