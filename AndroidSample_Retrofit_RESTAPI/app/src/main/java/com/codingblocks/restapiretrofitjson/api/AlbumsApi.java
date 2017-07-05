package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by GhanshamBansal on 05/07/17.
 */

public interface AlbumsApi {
    @GET("/albums")
    Call<ArrayList<Album>> getTitle();
}
