package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.UsersAdapter;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.apis.UserApi;
import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    private static final String TAG = "UserActivity";
    private UsersAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter(new ArrayList<User>(),this);
        recyclerView.setAdapter(usersAdapter);

        UserApi userApi = RestApi.getInstance().getUserApi();
        userApi.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<User>> call, @NonNull Response<ArrayList<User>> response) {
                usersAdapter.updateList(response.body());
                //Log.d(TAG, "onResponse: "+response.body());
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<User>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
        usersAdapter.setOnButtonClickListener(new OnButtonClickListener() {
            @Override
            public void onButtonClicked(int Id, int buttonId) {
                if(buttonId==UsersAdapter.POST_BUTTON){
                    Intent i = new Intent(UserActivity.this,PostActivity.class);
                    i.putExtra("userId",Id);
                    startActivity(i);
                }else if(buttonId==UsersAdapter.TODO_BUTTON){
                    Intent i = new Intent(UserActivity.this,TodoActivity.class);
                    i.putExtra("userId",Id);
                    startActivity(i);
                }
            }
        });
    }
}
