package com.codingblocks.restapiretrofitjson.apis;


import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Suraj on 6/30/2017.
 */

public interface TodoApi {
    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodosByUserId(
            @Query("userId") int userId
    );
}
