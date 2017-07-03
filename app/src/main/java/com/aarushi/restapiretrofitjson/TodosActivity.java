package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarushi.restapiretrofitjson.API.TodosAPI;
import com.aarushi.restapiretrofitjson.Adapters.PostsAdapter;
import com.aarushi.restapiretrofitjson.Adapters.TodosAdapter;
import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.Models.Todos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodosActivity extends AppCompatActivity {
    RecyclerView rvTodosList;
    TodosAdapter todosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        rvTodosList=(RecyclerView)findViewById(R.id.rvTodosList);
        rvTodosList.setLayoutManager(new LinearLayoutManager(this));
        todosAdapter=new TodosAdapter(this,new ArrayList<Todos>());
        rvTodosList.setAdapter(todosAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        TodosAPI todosAPI=retrofit.create(TodosAPI.class);

        Callback<ArrayList<Todos>> todoCallBack=new Callback<ArrayList<Todos>>() {
            @Override
            public void onResponse(Call<ArrayList<Todos>> call, Response<ArrayList<Todos>> response) {
                todosAdapter.updatePosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todos>> call, Throwable t) {

            }
        };

        int userId=getIntent().getIntExtra("userId",-1);
        if(userId!=-1){
            todosAPI.getTodosByUserId(userId).enqueue(todoCallBack);
        }
        else{
            todosAPI.getTodos().enqueue(todoCallBack);
        }
    }
}
