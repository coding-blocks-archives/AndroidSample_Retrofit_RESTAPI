package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yash on 2/7/17.
 */

public interface PhotosAPI {

    @GET("/photos")
    Call<ArrayList<Photos>> getPhotos();

    @GET("/photos")
    Call<ArrayList<Photos>> getPhotosByAlbumId(
            @Query("id") int id
    );

}
