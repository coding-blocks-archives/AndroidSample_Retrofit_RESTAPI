package com.codingblocks.restapiretrofitjson.apis;


import com.codingblocks.restapiretrofitjson.models.Post;
import com.codingblocks.restapiretrofitjson.models.Todo;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Suraj on 6/30/2017.
 */

public interface UserApi {

    @GET("/users")
    Call<ArrayList<User>> getUsers();

    interface PostApi{
        @GET("/users/{userId}/posts")
        Call<ArrayList<Post>> getPostsOfUserId(
                @Path("userId") int userId
        );
    }
    interface TodoApi{
        @GET("/users/{userId}/todos")
        Call<ArrayList<Todo>> getTodosOfUserId(
                @Path("userId") int userId
        );
    }
}
