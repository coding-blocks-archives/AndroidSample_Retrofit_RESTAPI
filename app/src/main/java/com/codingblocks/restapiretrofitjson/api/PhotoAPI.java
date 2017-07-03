package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ravneet on 2/7/17.
 */

public interface PhotoAPI {

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos();

    @GET("/albums/{id}/photos")
    Call<ArrayList<Album>> getPhotoById(
            @Path("id") int id
    );
}
