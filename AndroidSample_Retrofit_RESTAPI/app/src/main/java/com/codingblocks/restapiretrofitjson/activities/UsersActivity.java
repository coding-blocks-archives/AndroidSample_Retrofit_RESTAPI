package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.UserAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {

    public static final String TAG = "USERS";

    RecyclerView rvUserList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        rvUserList = (RecyclerView) findViewById(R.id.rvUserList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, new ArrayList<User>());
        rvUserList.setAdapter(userAdapter);
        userAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {

                switch (view.getId()) {
                    case R.id.btnUserComments:
                        Intent todosActIntent = new Intent(UsersActivity.this,
                                TodosActivity.class);
                        todosActIntent.putExtra("userId", itemId);
                        startActivity(todosActIntent);
                        break;
                    case R.id.btnUserPosts:
                        Intent postActIntent = new Intent(UsersActivity.this,
                                PostsActivity.class);

                        postActIntent.putExtra("userId", itemId);
                        startActivity(postActIntent);
                        break;
                }


            }
        });

        ((Button) findViewById(R.id.btnAllPosts)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(
                                UsersActivity.this,
                                PostsActivity.class
                        ));
                    }
                }
        );


        API.getInstance().getUsersAPI().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call,
                                   Response<ArrayList<User>> response) {
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

    }


}
