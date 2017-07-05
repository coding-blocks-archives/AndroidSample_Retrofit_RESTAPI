package com.example.dell.myappl11assign.api;

import com.example.dell.myappl11assign.models.Album;
import com.example.dell.myappl11assign.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dell on 01-07-2017.
 */

public interface AlbumsAPI {
    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    //interface PostsAPI{
        @GET("/albums/{id}/photos")
        Call<ArrayList<Photo>>getPhotosOfId(
                @Path("id") int id
        );
    //}
}
