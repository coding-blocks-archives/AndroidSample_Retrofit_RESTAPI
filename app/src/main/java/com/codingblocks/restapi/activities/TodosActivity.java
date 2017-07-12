package com.codingblocks.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.adapters.TodosAdapter;
import com.codingblocks.restapi.api.Client;
import com.codingblocks.restapi.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosActivity extends AppCompatActivity {
    RecyclerView rvTodosList;
    TodosAdapter todosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodosList = (RecyclerView) findViewById(R.id.rvTodosList);
        todosAdapter = new TodosAdapter(new ArrayList<Todo>());

        rvTodosList.setLayoutManager(new LinearLayoutManager(this));
        rvTodosList.setAdapter(todosAdapter);

        Client.getInstance().getApi().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todosAdapter.setTodos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });
    }
}
