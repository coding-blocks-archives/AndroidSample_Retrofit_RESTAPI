package com.codingblocks.restapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.models.Todo;

import java.util.ArrayList;

/**
 * Created by championswimmer on 12/07/17.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodoViewHolder> {

    private ArrayList<Todo> todos;

    public TodosAdapter(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbTodoTitle;

        TodoViewHolder(View itemView) {
            super(itemView);
            cbTodoTitle = (CheckBox) itemView.findViewById(R.id.cbTodoTitle);
        }

        void bindView (Todo todo) {
            cbTodoTitle.setText(todo.getTitle());
        }
    }
}
