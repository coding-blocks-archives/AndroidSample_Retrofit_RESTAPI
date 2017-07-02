package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by abheisenberg on 2/7/17.
 */

public interface PhotoAPI {

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotosOfAlbumId(@Query("albumId") int albumId);

}
