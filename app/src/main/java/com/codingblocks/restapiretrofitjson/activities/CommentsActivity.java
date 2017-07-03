package com.codingblocks.restapiretrofitjson.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.CommentsAdapter;
import com.codingblocks.restapiretrofitjson.apis.CommentApi;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    private static final String TAG = "CommentsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_comments);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final CommentsAdapter commentsAdapter = new CommentsAdapter(new ArrayList<Comment>(),this);
        recyclerView.setAdapter(commentsAdapter);

        CommentApi commentApi = RestApi.getInstance().getCommentApi();
        commentApi.getCommentsByPostId(getIntent().getIntExtra("postId",-1)).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Comment>> call, @NonNull Response<ArrayList<Comment>> response) {
                Log.d(TAG, "onResponse: "+response.body());
                commentsAdapter.updateList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Comment>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
