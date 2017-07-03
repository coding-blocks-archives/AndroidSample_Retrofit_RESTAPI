package com.codingblocks.restapiretrofitjson.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.TodosAdapter;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.apis.TodoApi;
import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {

    private static final String TAG = "TodoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_todo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final TodosAdapter todosAdapter = new TodosAdapter(new ArrayList<Todo>(),this);
        recyclerView.setAdapter(todosAdapter);

        TodoApi todoApi = RestApi.getInstance().getTodoApi();
        Call<ArrayList<Todo>> call;
        int userId = getIntent().getIntExtra("userId",-1);
        if(userId==-1){
            call = todoApi.getTodos();
        }else{
            call = todoApi.getTodosByUserId(userId);
        }
        call.enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Todo>> call, @NonNull Response<ArrayList<Todo>> response) {
                todosAdapter.updateList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Todo>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }
}
