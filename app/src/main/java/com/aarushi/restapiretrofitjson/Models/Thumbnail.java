package com.aarushi.restapiretrofitjson.Models;

/**
 * Created by hp on 7/1/2017.
 */

public class Thumbnail {

    String title;
    String thumbnailUrl;
    String url;
    public Thumbnail(String title, String thumbnailURL, String url) {
        this.title = title;
        this.thumbnailUrl = thumbnailURL;
        this.url=url;

    }

    public String getUrl() {
        return url;
    }


    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
