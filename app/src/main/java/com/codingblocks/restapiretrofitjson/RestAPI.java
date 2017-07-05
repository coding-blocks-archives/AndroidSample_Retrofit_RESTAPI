package com.codingblocks.restapiretrofitjson;

import com.codingblocks.restapiretrofitjson.api.CommentsAPI;
import com.codingblocks.restapiretrofitjson.api.PostsAPI;
import com.codingblocks.restapiretrofitjson.api.UsersAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshi on 7/5/2017.
 */

public class RestAPI {

    private static Retrofit apiInstance;

    private Retrofit retrofitInstance;
    private PostsAPI postsAPI;
    private UsersAPI usersAPI;
    private CommentsAPI commentsAPI;

    private RestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        postsAPI = retrofitInstance.create(PostsAPI.class);
        usersAPI = retrofitInstance.create(UsersAPI.class);
        commentsAPI = retrofitInstance.create(CommentsAPI.class);
    }

    public PostsAPI getPostsAPI() {
        return postsAPI;
    }

    public UsersAPI getUsersAPI() {
        return usersAPI;
    }

    public CommentsAPI getCommentsAPI() {
        return commentsAPI;
    }

    public static Retrofit getInstance(){
        if (apiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    )
                    .build();
        }
        return apiInstance;

//    public static  RestAPI getInstance(){
//        if (apiInstance == null){
//            apiInstance = new RestAPI();
//        }
//        return apiInstance;
//    }
    }}


