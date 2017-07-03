package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aarushi.restapiretrofitjson.API.UsersAPI;
import com.aarushi.restapiretrofitjson.Adapters.UserAdapter;
import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    RecyclerView rvUsersList;
    UserAdapter userAdapter;
    public static final String TAG="UA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        rvUsersList=(RecyclerView)findViewById(R.id.rvUsersList);
        rvUsersList.setLayoutManager(new LinearLayoutManager(this));
        userAdapter=new UserAdapter(this,new ArrayList<User>());
        userAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int albumId) {
                Intent i=new Intent(UserActivity.this,PostsActivity.class);
                i.putExtra("userId",albumId+1);
                startActivity(i);
            }
        });
        userAdapter.setOnItemClickListener1(new OnItemClickListener() {
            @Override
            public void OnItemClick(int albumId) {
                Intent i=new Intent(UserActivity.this,TodosActivity.class);
                i.putExtra("userId",albumId+1);
                startActivity(i);
            }
        });
        rvUsersList.setAdapter(userAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        UsersAPI usersAPI=retrofit.create(UsersAPI.class);
        usersAPI.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
               // Log.d(TAG, "onResponse: ");

                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

    }
}
