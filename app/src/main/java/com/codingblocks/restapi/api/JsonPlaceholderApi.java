package com.codingblocks.restapi.api;

import com.codingblocks.restapi.models.Album;
import com.codingblocks.restapi.models.Post;
import com.codingblocks.restapi.models.Todo;
import com.codingblocks.restapi.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by championswimmer on 12/07/17.
 */

public interface JsonPlaceholderApi {
    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();
}
