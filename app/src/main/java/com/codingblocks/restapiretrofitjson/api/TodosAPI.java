package com.codingblocks.restapiretrofitjson.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by championswimmer on 02/07/17.
 */

public interface TodosAPI {

    @GET ("/todos")
    Call<ArrayList<Todo>> getTodos();

    @GET ("/todos")
    Call<ArrayList<Todo>> getTodoByUserId(
            @Query("userId")int userId
    );

    @GET ("/todos/{id}")
    Call<ArrayList<Todo>> getTodoById(
            @Path("id") int id
    );


}
