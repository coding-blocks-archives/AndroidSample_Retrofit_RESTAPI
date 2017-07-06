package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GhanshamBansal on 06/07/17.
 */


public interface PicApi {
    @GET("/photos/{id}")
    Call<Photo> getPicById (
            @Path("id") int id
    );
}
