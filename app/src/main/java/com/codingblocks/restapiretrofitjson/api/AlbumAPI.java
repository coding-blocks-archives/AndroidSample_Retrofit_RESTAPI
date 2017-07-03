package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yash on 2/7/17.
 */

public interface AlbumAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

/*
    @GET("/albums/{id}/photos")
    Call<ArrayList<Photos>> getPhotosOfAlbum(
            @Path("id") int id
    );

  */
  interface PhotosAPI {

        @GET("/albums/{id}/photos")
        Call<ArrayList<Photos>> getPhotosOfAlbum(
                @Path("id") int id
        );

    }


}
