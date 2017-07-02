package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by abheisenberg on 2/7/17.
 */

public interface AlbumAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAllAlbums();
}
