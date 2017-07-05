package com.example.dell.myappl11assign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.myappl11assign.adapters.TodoAdapter;
import com.example.dell.myappl11assign.api.TodosAPI;
import com.example.dell.myappl11assign.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodosActivity extends AppCompatActivity {
    public static final String TAG="TodosActivity";
    RecyclerView rvTodosList;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodosList= (RecyclerView) findViewById(R.id.rvTodosList);
        rvTodosList.setLayoutManager(new LinearLayoutManager(this));
        todoAdapter=new TodoAdapter(this,new ArrayList<Todo>());
        rvTodosList.setAdapter(todoAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        TodosAPI todosAPI = retrofit.create(TodosAPI.class);
        final Callback<ArrayList<Todo>>todoCallBack=new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d(TAG, "onResponse: ********************");
                todoAdapter.updateTodos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        };
        int userIdReceived=getIntent().getIntExtra("userId",-1);
        if(userIdReceived!=-1){
            todosAPI.getTodosByUserId(userIdReceived).enqueue(todoCallBack);
        }else{
            todosAPI.getTodos().enqueue(todoCallBack);
        }

    }
}
