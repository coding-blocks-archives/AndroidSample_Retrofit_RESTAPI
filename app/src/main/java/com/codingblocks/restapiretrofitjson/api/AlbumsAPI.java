package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kunalrustagi on 7/5/17.
 */

public interface AlbumsAPI {

    @GET("/photos")
    Call<ArrayList<Album>> getAlbums();


}
