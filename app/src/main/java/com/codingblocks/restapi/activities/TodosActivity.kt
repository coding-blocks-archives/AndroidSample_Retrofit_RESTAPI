package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.TodosAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Todo
import com.codingblocks.restapi.utils.kotlin.callback
import kotlinx.android.synthetic.main.activity_todos.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class TodosActivity : AppCompatActivity() {
    internal var todosAdapter = TodosAdapter(ArrayList<Todo>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        rvTodosList.layoutManager = LinearLayoutManager(this)
        rvTodosList.adapter = todosAdapter


        Client.getInstance().api.todos.enqueue(callback({ throwable, response ->
            response?.body()?.let { todosAdapter.setTodos(it) }
        }))
    }
}
