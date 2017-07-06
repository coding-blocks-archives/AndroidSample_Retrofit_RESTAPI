package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ashpreet on 06-07-2017.
 */

public interface PhotosAPI {

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos();

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotosByAlbumId(
            @Query("albumId") int albumId
    );
}
