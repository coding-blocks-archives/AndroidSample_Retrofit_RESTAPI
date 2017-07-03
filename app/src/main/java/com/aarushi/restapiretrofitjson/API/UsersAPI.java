package com.aarushi.restapiretrofitjson.API;

import com.aarushi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hp on 7/1/2017.
 */

public interface UsersAPI {
    @GET("/users")
    Call<ArrayList<User>> getUsers();

}
