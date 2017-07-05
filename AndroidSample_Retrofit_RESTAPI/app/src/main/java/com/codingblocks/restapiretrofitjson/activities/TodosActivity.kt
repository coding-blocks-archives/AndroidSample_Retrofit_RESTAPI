package com.codingblocks.restapiretrofitjson.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

import kotlinx.android.synthetic.main.activity_todos.*

import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.TodoAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.models.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        rvTodosList.layoutManager = LinearLayoutManager(this)
        var todoAdapter = TodoAdapter(ArrayList<Todo>())
        rvTodosList.adapter = todoAdapter

        var todoCallback = object:  Callback<ArrayList<Todo>> {
            override fun onFailure(call: Call<ArrayList<Todo>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<ArrayList<Todo>>?, response: Response<ArrayList<Todo>>?) {
                todoAdapter.updateTodos(response!!.body()!!)
            }

        }
        var userId = intent.getIntExtra("userId", -1)
        if (userId != -1) {
            API.getInstance().todosAPI.getTodos(userId).enqueue(todoCallback)

        } else {
            API.getInstance().todosAPI.getTodos(null).enqueue(todoCallback)
        }



    }
}
