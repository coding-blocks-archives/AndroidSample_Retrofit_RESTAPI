package com.codingblocks.restapi.models;

/**
 * Created by championswimmer on 12/07/17.
 */

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;

    public User(int id, String name, String username, String email, String phone) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
