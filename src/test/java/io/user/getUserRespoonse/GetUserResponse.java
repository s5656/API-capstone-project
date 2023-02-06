package io.user.getUserRespoonse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetUserResponse {

    private int statusCode;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("data")
    private List<Data> dataList;
    private String total;

    public int getStatusCode() {
        return statusCode;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public String getTotal() {
        return total;
    }

    public int getLimit() {
        return limit;
    }

    public String getPage() {
        return page;
    }

    private int limit;
    private String page;
    public static class Pagination {
        private int total;
        private int pages;
        private int limit;
        private Links links;
        private int page;
    }
    public static class Links {
        private String next;
        private String current;
        private String previous;

        public String getNext() {
            return next;
        }

        public String getCurrent() {
            return current;
        }

        public String getPrevious() {
            return previous;
        }
    }

    public static class Data {
        private String firstName;
        private String lastName;
        private String id;
        private String title;
        private String picture;

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
    }
}
