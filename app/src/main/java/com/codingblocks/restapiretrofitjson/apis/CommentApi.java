package com.codingblocks.restapiretrofitjson.apis;


import com.codingblocks.restapiretrofitjson.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Suraj on 6/30/2017.
 */

public interface CommentApi {

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId(
            @Query("postId") int postId
    );
}
