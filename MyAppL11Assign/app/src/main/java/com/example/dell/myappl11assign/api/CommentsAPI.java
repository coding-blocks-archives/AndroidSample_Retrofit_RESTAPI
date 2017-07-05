package com.example.dell.myappl11assign.api;

import com.example.dell.myappl11assign.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 01-07-2017.
 */

public interface CommentsAPI {

    @GET("/comments")
    Call<ArrayList<Comment>> getComments();

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId(
            @Query("postId") int postId
    );

}
