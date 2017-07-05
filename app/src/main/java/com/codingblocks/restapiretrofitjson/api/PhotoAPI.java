package com.codingblocks.restapiretrofitjson.api;

import android.support.annotation.Nullable;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HP on 05-07-2017.
 */

public interface PhotoAPI {
    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos (
            @Nullable
            @Query("albumId") Integer albumId
    );

    @GET("/photos/{id}")
    Call<Photo> getPhoto(
            @Path("id") Integer id
    );
}
