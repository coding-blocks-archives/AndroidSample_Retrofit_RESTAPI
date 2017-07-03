package com.aarushi.restapiretrofitjson.Models;

/**
 * Created by hp on 7/1/2017.
 */

public class Todos {
    String title;
    Boolean completed;

    public Todos(Boolean completed) {
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
