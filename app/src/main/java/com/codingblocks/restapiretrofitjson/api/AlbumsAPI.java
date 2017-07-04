package com.codingblocks.restapiretrofitjson.api;

/**
 * Created by Arunima Mitra on 03-07-2017.
 */

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Pic;

import java.util.ArrayList;
import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Pic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pervy_sage on 1/7/17.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>>getAlbumsbyUserId(
            @Query("userId") Integer userId
    );

    interface PicsApi{
        @GET("/photos")
        Call<ArrayList<Pic>>getPhotos();

        @GET("/albums/{id}/photos")
        Call<ArrayList<Pic>>getPhotosOfAlbumId(
                @Path("id")int id
        );
    }
}