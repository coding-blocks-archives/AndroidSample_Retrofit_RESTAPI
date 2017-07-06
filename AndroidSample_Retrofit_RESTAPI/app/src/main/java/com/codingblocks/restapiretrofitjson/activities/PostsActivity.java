package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.codingblocks.restapiretrofitjson.MainActivity;
import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PostAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.PostsAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    public static final String TAG = "PA";

    RecyclerView rvPostsList;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPostsList = (RecyclerView) findViewById(R.id.rvPostsList);
        rvPostsList.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter(this, new ArrayList<Post>());
        rvPostsList.setAdapter(postAdapter);
        postAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent i = new Intent(PostsActivity.this, CommentsActivity.class);
                i.putExtra("postId", itemId);
                startActivity(i);
            }
        });


        PostsAPI postsAPI = API.getInstance().getPostsAPI();
        Callback<ArrayList<Post>> postCallback = new Callback<ArrayList<Post>>() {

            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                Log.d(TAG, "onResponse: ");
                postAdapter.updatePosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        };
        int userIdReceived = getIntent().getIntExtra("userId", -1);
        if (userIdReceived != -1) {
            postsAPI.getPostsByUserId(userIdReceived).enqueue(postCallback);
        } else {
            postsAPI.getPosts().enqueue(postCallback);
        }

    }
}
