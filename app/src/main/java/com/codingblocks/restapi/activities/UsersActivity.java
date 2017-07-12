package com.codingblocks.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.adapters.UsersAdapter;
import com.codingblocks.restapi.api.Client;
import com.codingblocks.restapi.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    RecyclerView rvUsersList;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        rvUsersList = (RecyclerView) findViewById(R.id.rvUsersList);
        rvUsersList.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter(new ArrayList<User>());
        rvUsersList.setAdapter(usersAdapter);

        Client.getInstance().getApi().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                usersAdapter.setUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }
}
