package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;



import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.TodoAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.TodosAPI;
import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodosActivity extends AppCompatActivity {

    RecyclerView rvTodosList;
    TodoAdapter todosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        rvTodosList=(RecyclerView)findViewById(R.id.rvTodosList);
        rvTodosList.setLayoutManager(new LinearLayoutManager(this));
        todosAdapter=new TodoAdapter(this,new ArrayList<Todo>());
        rvTodosList.setAdapter(todosAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        TodosAPI todosAPI=retrofit.create(TodosAPI.class);

        Callback<ArrayList<Todo>> todoCallBack=new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todosAdapter.updateTodos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

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
