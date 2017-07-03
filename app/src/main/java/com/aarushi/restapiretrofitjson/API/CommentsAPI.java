package com.aarushi.restapiretrofitjson.API;

import com.aarushi.restapiretrofitjson.Models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hp on 7/2/2017.
 */

public interface CommentsAPI {

    @GET("posts/{postId}/comments")
    Call<ArrayList<Comment>> getCommentsByPostId(@Path("postId") int postId);
}
