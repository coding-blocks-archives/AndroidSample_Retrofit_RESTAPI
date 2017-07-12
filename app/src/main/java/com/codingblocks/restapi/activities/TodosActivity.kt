package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.TodosAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Todo
import kotlinx.android.synthetic.main.activity_todos.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        val todosAdapter = TodosAdapter(ArrayList<Todo>())

        rvTodosList.layoutManager = LinearLayoutManager(this)
        rvTodosList.adapter = todosAdapter

        Client.api.todos.enqueue(object : Callback<ArrayList<Todo>> {
            override fun onResponse(call: Call<ArrayList<Todo>>, response: Response<ArrayList<Todo>>) {
                todosAdapter.setTodos(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Todo>>, t: Throwable) {

            }
        })
    }
}
