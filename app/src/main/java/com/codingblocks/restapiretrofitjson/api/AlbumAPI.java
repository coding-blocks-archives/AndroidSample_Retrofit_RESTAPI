package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HP on 03-07-2017.
 */

public interface AlbumAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbum();

    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getPhotoById(
            @Path("id") int id
    );
}