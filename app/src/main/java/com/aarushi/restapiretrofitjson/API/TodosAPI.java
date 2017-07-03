package com.aarushi.restapiretrofitjson.API;

import com.aarushi.restapiretrofitjson.Models.Todos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hp on 7/1/2017.
 */

public interface TodosAPI {
    @GET("/todos")
    Call<ArrayList<Todos>> getTodos();

    @GET("/users/{userId}/todos")
    Call<ArrayList<Todos>> getTodosByUserId(@Path("userId") int userId);
}
