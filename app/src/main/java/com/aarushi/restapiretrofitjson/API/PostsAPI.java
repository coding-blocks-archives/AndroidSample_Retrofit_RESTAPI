package com.aarushi.restapiretrofitjson.API;

import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hp on 7/1/2017.
 */

public interface PostsAPI {
    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/users/{userId}/posts")
    Call<ArrayList<Post>> getPostsByUserId(@Path("userId") int userId);

}
