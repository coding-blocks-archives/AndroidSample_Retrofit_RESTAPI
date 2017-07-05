package com.example.dell.myappl11assign.api;

import com.example.dell.myappl11assign.models.Comment;
import com.example.dell.myappl11assign.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by dell on 01-07-2017.
 */

public interface PostsAPI {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post>getPostById(
            @Path("id") int id
    );

    @GET("/posts")
    Call<ArrayList<Post>>getPostsByUserId(
            @Query("userId") int userId
    );

    interface  CommentsAPI{
        @GET("/posts/{postId}/comments")
        Call<ArrayList<Comment>>getCommentsOfPostId(
                @Path("postId") int postId
        );
    }

}
