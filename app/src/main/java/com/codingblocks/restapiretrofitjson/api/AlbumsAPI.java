package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Thumbnail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Harshi on 7/5/2017.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums ();
    @GET("/albums/{id}/photos")
    Call<ArrayList<Thumbnail>> getThumbnail(@Path("id") int albumId);
}
