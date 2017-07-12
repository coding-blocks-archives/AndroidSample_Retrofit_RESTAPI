package com.codingblocks.restapi.models;

/**
 * Created by championswimmer on 12/07/17.
 */

public class Todo {
    private int id;
    private int userId;
    private String title;
    private boolean completed;

    public Todo(int id, int userId, String title, boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }
}
