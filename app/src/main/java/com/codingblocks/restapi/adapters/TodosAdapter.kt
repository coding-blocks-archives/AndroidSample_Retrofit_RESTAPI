package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Todo

import kotlinx.android.synthetic.main.list_item_todo.view.*

import java.util.ArrayList

/**
 * Created by championswimmer on 12/07/17.
 */

class TodosAdapter(private var todos: ArrayList<Todo>?) : RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {

    fun setTodos(todos: ArrayList<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
                todoView = LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_todo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindView(todos!![position])
    }

    override fun getItemCount(): Int {
        return (todos?.size ?: 0)
    }

    inner class TodoViewHolder(val todoView: View) : RecyclerView.ViewHolder(todoView) {


        fun bindView(todo: Todo) {
            todoView.cbTodoTitle.text = todo.title
            todoView.cbTodoTitle.isChecked = todo.isCompleted
        }
    }
}
