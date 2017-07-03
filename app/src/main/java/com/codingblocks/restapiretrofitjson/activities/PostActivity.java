package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PostsAdapter;
import com.codingblocks.restapiretrofitjson.apis.PostApi;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";
    private PostsAdapter postsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter = new PostsAdapter(new ArrayList<Post>(),this);
        recyclerView.setAdapter(postsAdapter);

        PostApi postApi = RestApi.getInstance().getPostApi();
        Call<ArrayList<Post>> call;
        int userId = getIntent().getIntExtra("userId",-1);
        if(userId==-1)
            call = postApi.getPostsByUserId(null);
        else
            call = postApi.getPostsByUserId(userId);

        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Post>> call, @NonNull Response<ArrayList<Post>> response) {
                postsAdapter.updateList(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<Post>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
                t.printStackTrace();
            }
        });

        postsAdapter.setOnButtonClickListener(new OnButtonClickListener() {
            @Override
            public void onButtonClicked(int Id, int buttonId) {
                Intent i = new Intent(PostActivity.this,CommentsActivity.class);
                i.putExtra("postId",Id);
                startActivity(i);
            }
        });
    }
}
