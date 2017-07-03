package com.aarushi.restapiretrofitjson.Models;

/**
 * Created by hp on 7/1/2017.
 */

public class Post {
    String title;
    String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
