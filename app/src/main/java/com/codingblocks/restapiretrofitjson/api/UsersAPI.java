package com.codingblocks.restapiretrofitjson.api;

import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by championswimmer on 29/06/17.
 */

public interface UsersAPI {

    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/users/{id}")
    Call<User> getUser(
            @Path("id") Integer userId
    );
}
