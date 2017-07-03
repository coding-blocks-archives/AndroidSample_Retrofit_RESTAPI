package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anirudh on 03/07/17.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums() ;
    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getPhotoOfAlbum(@Path("id") int albumId) ;
}
