package com.codingblocks.restapiretrofitjson.apis;


import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Suraj on 6/30/2017.
 */

public interface AlbumApi {

    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    interface PhotoApi{
        @GET("/albums/{albumId}/photos")
        Call<ArrayList<Photo>> getPhotosOfAlbumId(
                @Path("albumId") int albumId
        );
    }
}
