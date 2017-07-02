package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photos;

import java.util.ArrayList;
import com.codingblocks.restapiretrofitjson.models.Album;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pervy_sage on 1/7/17.
 */

public interface AlbumsApi {
    @GET("/albums")
    Call<ArrayList<Album>>getAlbumsbyUserId(
            @Query("userId") Integer userId
    );

    interface PhotosApi{
        @GET("/photos")
        Call<ArrayList<Photos>>getPhotos();

        @GET("/albums/{id}/photos")
        Call<ArrayList<Photos>>getPhotosOfAlbumId(
                @Path("id")int id
        );
    }
}
