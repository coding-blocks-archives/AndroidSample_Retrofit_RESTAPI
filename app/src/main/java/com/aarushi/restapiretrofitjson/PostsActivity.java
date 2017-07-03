package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarushi.restapiretrofitjson.API.PostsAPI;
import com.aarushi.restapiretrofitjson.API.UsersAPI;
import com.aarushi.restapiretrofitjson.Adapters.PostsAdapter;
import com.aarushi.restapiretrofitjson.Adapters.UserAdapter;
import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {
    RecyclerView rvPostsList;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPostsList=(RecyclerView)findViewById(R.id.rvPostsList);
        rvPostsList.setLayoutManager(new LinearLayoutManager(this));
        postsAdapter=new PostsAdapter(this,new ArrayList<Post>());
        postsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int albumId) {
                Intent i=new Intent(PostsActivity.this,CommentsActivity.class);
                i.putExtra("postId",albumId);
                startActivity(i);
            }
        });
        rvPostsList.setAdapter(postsAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();



        PostsAPI postsAPI=retrofit.create(PostsAPI.class);



        Callback<ArrayList<Post>> postCallBack=new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postsAdapter.updatePosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        };

        int userId=getIntent().getIntExtra("userId",-1);
        if(userId!=-1){
            postsAPI.getPostsByUserId(userId).enqueue(postCallBack);
        }
        else{
            postsAPI.getPosts().enqueue(postCallBack);
        }

    }
}
