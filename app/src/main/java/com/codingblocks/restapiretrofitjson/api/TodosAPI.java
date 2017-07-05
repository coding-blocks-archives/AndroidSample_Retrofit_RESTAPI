package com.codingblocks.restapiretrofitjson.api;

import android.support.annotation.Nullable;

import com.codingblocks.restapiretrofitjson.models.Todos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by championswimmer on 02/07/17.
 */

public interface TodosAPI {

    @GET("/todos")
    Call<ArrayList<Todos>> getTodos(
            @Nullable
            @Query("userId") Integer userId
    );


}
