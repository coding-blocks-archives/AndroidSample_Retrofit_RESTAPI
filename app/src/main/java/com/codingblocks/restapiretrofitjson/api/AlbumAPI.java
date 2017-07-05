package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by namankhanna on 7/5/17.
 */

public interface AlbumAPI {

    @GET("/albums")
    Call<ArrayList<Album>> getAlbum();

}
