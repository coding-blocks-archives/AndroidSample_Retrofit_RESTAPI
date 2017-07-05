package com.example.dell.myappl11assign.api;

import com.example.dell.myappl11assign.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 01-07-2017.
 */

public interface TodosAPI {

    @GET("/todos")
    Call<ArrayList<Todo>>getTodos();

    @GET("/todos")
    Call<ArrayList<Todo>>getTodosByUserId(
            @Query("userId") int userId
    );

}
