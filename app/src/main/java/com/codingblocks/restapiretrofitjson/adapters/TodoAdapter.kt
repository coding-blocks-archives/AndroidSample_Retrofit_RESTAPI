package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.models.Todo

import kotlinx.android.synthetic.main.list_item_todo.view.*

/**
 * Created by championswimmer on 02/07/17.
 */
public class TodoAdapter (
        var todos: ArrayList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    fun updateTodos(todos: ArrayList<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val (_, _, title, completed) = todos!![position]

        holder.tvTodoTitle.text = title
        holder.todocheck.isChecked = completed

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TodoViewHolder {

        var itemView: View = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_todo, parent, false)

        return TodoViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        Log.d("TODOS", todos.size.toString())
       return todos.size
    }


    inner class TodoViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        var todocheck: CheckBox
        var tvTodoTitle: TextView

        init {

            tvTodoTitle = itemView.findViewById(R.id.tvTodoTitle) as TextView
            todocheck = itemView.findViewById(R.id.todocheck) as CheckBox

        }
    }
}