package com.example.dell.myappl11assign.api;

import com.example.dell.myappl11assign.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dell on 01-07-2017.
 */

public interface UsersAPI {

    @GET("/users")
    Call<ArrayList<User>> getUsers ();
}
