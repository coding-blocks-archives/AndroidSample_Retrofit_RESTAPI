package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by namankhanna on 7/5/17.
 */

public interface PhotoAPI {
    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getPhotoById(
            @Path("id") int id
    );
}
