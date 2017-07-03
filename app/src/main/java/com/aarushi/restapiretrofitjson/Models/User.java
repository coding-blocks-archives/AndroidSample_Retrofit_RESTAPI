package com.aarushi.restapiretrofitjson.Models;

/**
 * Created by hp on 7/1/2017.
 */

public class User {

    String username;
    String name;
    String phone;
    String email;

    public User(String username, String name, String phone, String email) {
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
