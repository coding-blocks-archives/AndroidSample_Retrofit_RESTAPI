package com.codingblocks.restapi.models;

/**
 * Created by championswimmer on 12/07/17.
 */

public class Album {
    private int id;
    private int userId;
    private String title;

    public Album(int id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }
}
