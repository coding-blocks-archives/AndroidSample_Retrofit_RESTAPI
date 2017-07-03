package com.aarushi.restapiretrofitjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarushi.restapiretrofitjson.API.CommentsAPI;
import com.aarushi.restapiretrofitjson.Adapters.CommentsAdapter;
import com.aarushi.restapiretrofitjson.Adapters.PostsAdapter;
import com.aarushi.restapiretrofitjson.Models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {

    RecyclerView rvCommentsList;
    CommentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        rvCommentsList=(RecyclerView)findViewById(R.id.rvCommentsList);
        rvCommentsList.setLayoutManager(new LinearLayoutManager(this));
        commentsAdapter=new CommentsAdapter(this,new ArrayList<Comment>());
        rvCommentsList.setAdapter(commentsAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        CommentsAPI commentsAPI=retrofit.create(CommentsAPI.class);
        commentsAPI.getCommentsByPostId(getIntent().getIntExtra("postId",-1)).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                commentsAdapter.updateComments(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });
    }
}
