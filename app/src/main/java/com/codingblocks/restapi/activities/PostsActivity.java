package com.codingblocks.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.adapters.PostsAdapter;
import com.codingblocks.restapi.api.Client;
import com.codingblocks.restapi.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    RecyclerView rvPostsList;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPostsList = (RecyclerView) findViewById(R.id.rvPostsList);
        postsAdapter = new PostsAdapter(new ArrayList<Post>());

        rvPostsList.setLayoutManager(new LinearLayoutManager(this));
        rvPostsList.setAdapter(postsAdapter);

        Client.getInstance().getApi().getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postsAdapter.setPosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}
