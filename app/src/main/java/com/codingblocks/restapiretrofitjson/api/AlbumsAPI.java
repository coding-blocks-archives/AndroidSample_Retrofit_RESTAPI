package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ashpreet on 06-07-2017.
 */

public interface AlbumsAPI {

    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    @GET("/albums/{id}")
    Call<Album> getAlbumById(
            @Path("id") int id
    );

    @GET("/albums")
    Call<ArrayList<Album>> getAlbumsByUserId(
            @Query("userId") int userId
    );
}
