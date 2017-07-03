package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    private ArrayList<Todo> todosList;
    private final Context context;

    public TodosAdapter(ArrayList<Todo> todosList, Context context) {
        this.todosList = todosList;
        this.context = context;
    }

    public void updateList(ArrayList<Todo> todosList){
        this.todosList = todosList;
        notifyDataSetChanged();
    }

    @Override
    public TodosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_todo,parent,false);
        return new TodosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodosViewHolder holder, int position) {

        final Todo todo = todosList.get(position);
        holder.todoTitle.setText(todo.getTitle());
        holder.todoCheckBox.setChecked(todo.getCompleted());
    }

    @Override
    public int getItemCount() {
        return todosList.size();
    }

    class TodosViewHolder extends RecyclerView.ViewHolder{
        final TextView todoTitle;
        final CheckBox todoCheckBox;
        public TodosViewHolder(View itemView) {
            super(itemView);
            todoTitle = itemView.findViewById(R.id.tv_Todo);
            todoCheckBox = itemView.findViewById(R.id.cb_Todo);
        }
    }
}
