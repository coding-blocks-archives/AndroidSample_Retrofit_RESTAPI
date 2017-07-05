package com.example.dell.myappl11assign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.myappl11assign.adapters.PostAdapter;
import com.example.dell.myappl11assign.api.PostsAPI;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {
    public static final String TAG = "PostsActivity";
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
            public void onItemClick(int itemId) {
                Intent commActIntent = new Intent(PostsActivity.this,CommentsActivity.class);
                commActIntent.putExtra("userId",itemId);
                startActivity(commActIntent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        PostsAPI postsAPI = retrofit.create(PostsAPI.class);
        Callback<ArrayList<Post>> postCallback = new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                Log.d(TAG, "onResponse: ****************");
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
