package io.dummyapi.user.getUserRespoonse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class GetUserResponse{
    @Setter
    private int statusCode;
    @JsonProperty("data")
    private List<Data> dataList;
    private String total;
    private int limit;
    private String page;

    @Getter
    public static class Pagination{
        private int total;
        private int pages;
        private int limit;
        private Links links;
        private int page;
    }
    @Getter
    public static class Links{
        private String next;
        private String current;
        private String previous;
    }
    @Getter
    public static class Data{
        private String firstName;
        private String lastName;
        private String id;
        private String title;
        private String picture;
    }
}
