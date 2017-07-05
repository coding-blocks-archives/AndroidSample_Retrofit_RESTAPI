package com.codingblocks.restapiretrofitjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.codingblocks.restapiretrofitjson.adapters.TodosAdapter;
import com.codingblocks.restapiretrofitjson.api.TodosAPI;
import com.codingblocks.restapiretrofitjson.models.Todos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshi on 7/5/2017.
 */

public class TodosActiviy extends AppCompatActivity {

    public static final String TAG = "USERS";

    RecyclerView rvTodosList;
    TodosAdapter todosAdapter;
    Button btnShowTodos, btnShowPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodosList = (RecyclerView) findViewById(R.id.rvTodosList);
        rvTodosList.setLayoutManager(new LinearLayoutManager(this));
        todosAdapter = new TodosAdapter(this, new ArrayList<Todos>());
        rvTodosList.setAdapter(todosAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        final TodosAPI todosAPI = retrofit.create(TodosAPI.class);
//
        final Callback<ArrayList<Todos>> postCallback = new Callback<ArrayList<Todos>>() {

            @Override
            public void onResponse(Call<ArrayList<Todos>> call, Response<ArrayList<Todos>> response) {
                todosAdapter.updateTodos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todos>> call, Throwable t) {

            }
        };
        int userIdReceived = getIntent().getIntExtra("userId", -1);
        if (userIdReceived != -1) {
            todosAPI.getTodos(userIdReceived).enqueue(postCallback);
        } else {
            todosAPI.getTodos(null).enqueue(postCallback);
        }}}