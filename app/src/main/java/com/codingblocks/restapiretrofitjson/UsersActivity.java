package com.codingblocks.restapiretrofitjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.codingblocks.restapiretrofitjson.adapters.UserAdapter;
import com.codingblocks.restapiretrofitjson.api.UsersAPI;
import com.codingblocks.restapiretrofitjson.interfaces.onItemClickListener;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshi on 7/5/2017.
 */

public class UsersActivity extends AppCompatActivity {

    public static final String TAG = "USERS";

    RecyclerView rvUserList;
    UserAdapter userAdapter;
    Button btnShowTodos, btnShowPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        rvUserList = (RecyclerView) findViewById(R.id.rvUserList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, new ArrayList<User>());

        userAdapter.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Intent postActIntent = new Intent(UsersActivity.this,
                        PostsActivity.class);

                postActIntent.putExtra("userId", itemId + 1);
                startActivity(postActIntent);
            }
        });
        userAdapter.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Intent postActIntent = new Intent(UsersActivity.this,
                        AlbumsActivity.class);

                postActIntent.putExtra("userId", itemId + 1);
                startActivity(postActIntent);
            }
        });
        rvUserList.setAdapter(userAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        UsersAPI usersAPI = retrofit.create(UsersAPI.class);
//          final UsersAPI usersAPI = RestAPI.getInstance().create(UsersAPI.class);

        Callback<ArrayList<User>> postCallback = new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }

        };

        usersAPI.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call,
                                   Response<ArrayList<User>> response) {
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

//        btnShowTodos = (Button) findViewById(R.id.tvUserShowTodos);
//        btnShowPosts = (Button) findViewById(R.id.tvUserShowPost);

//        btnShowTodos.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(UsersActivity.this,TodosActiviy.class);
//                startActivity(i);
//            }
//        });
//        btnShowPosts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i =  new Intent(UsersActivity.this,PostsActivity.class);
//            }
//        });
    }}
