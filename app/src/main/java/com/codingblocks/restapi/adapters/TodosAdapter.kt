package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Todo

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
        val li = LayoutInflater.from(parent.context)
        return TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindView(todos!![position])
    }

    override fun getItemCount(): Int {
        return (todos?.size ?: 0)
    }

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cbTodoTitle: CheckBox

        init {
            cbTodoTitle = itemView.findViewById<View>(R.id.cbTodoTitle) as CheckBox
        }

        fun bindView(todo: Todo) {
            cbTodoTitle.text = todo.title
            cbTodoTitle.isChecked = todo.isCompleted
        }
    }
}
