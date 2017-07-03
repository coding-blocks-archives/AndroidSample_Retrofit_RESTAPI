package com.aarushi.restapiretrofitjson.Models;

/**
 * Created by hp on 7/2/2017.
 */

public class Comment {
    String body;
    String email;
    String name;

    public Comment(String body, String email, String name) {
        this.body = body;
        this.email = email;
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
