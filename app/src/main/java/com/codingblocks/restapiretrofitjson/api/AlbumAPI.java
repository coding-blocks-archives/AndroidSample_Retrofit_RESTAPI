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

public interface AlbumAPI {

    @GET("/album")
    Call<ArrayList<Album>> getAlbum();

    @GET("/album/{id}/photos")
    Call<ArrayList<Photo>> getPhotoById(
            @Path("id") int id
    );
}
