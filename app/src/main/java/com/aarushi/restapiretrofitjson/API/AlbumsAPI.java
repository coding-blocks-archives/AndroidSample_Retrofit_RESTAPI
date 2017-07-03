package com.aarushi.restapiretrofitjson.API;

import com.aarushi.restapiretrofitjson.Models.Album;
import com.aarushi.restapiretrofitjson.Models.Thumbnail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hp on 7/1/2017.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();


    @GET("/albums/{id}/photos")
    Call<ArrayList<Thumbnail>> getThumbnail(@Path("id") int albumId);
}
