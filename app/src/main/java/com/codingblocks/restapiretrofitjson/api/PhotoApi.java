package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by GhanshamBansal on 06/07/17.
 */

public interface PhotoApi {
    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getPhotoByAlbumId(
            @Path("id") int id
    );
}
