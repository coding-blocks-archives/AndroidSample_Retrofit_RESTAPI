package com.codingblocks.restapiretrofitjson.api;

import android.support.annotation.Nullable;

import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 05-07-2017.
 */

public interface AlbumAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums (
            @Nullable
            @Query("userId") Integer userId
    );
}
