package com.codingblocks.restapiretrofitjson.apis;

import android.support.annotation.Nullable;


import com.codingblocks.restapiretrofitjson.models.Comment;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Suraj on 6/30/2017.
 */

public interface PostApi {

//    @GET("/posts")
//    Call<ArrayList<Post>> getPosts();

    @GET("/posts/{id}")
    Call<ArrayList<Post>> getPostsbyId(
            @Path("id") int id
    );

    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId(
            @Nullable
            @Query("userId") Integer userId
    );
    interface CommentApi{
        @GET("posts/{postId}/comments/")
        Call<ArrayList<Comment>> getCommentsOfPostId(
                @Path("postId") int postId
        );
    }
}
