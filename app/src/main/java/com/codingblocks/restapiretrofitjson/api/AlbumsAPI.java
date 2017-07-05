package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 06-07-2017.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

}
