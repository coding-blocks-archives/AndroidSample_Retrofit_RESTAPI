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
 * Created by namankhanna on 7/5/17.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    public TodoAdapter(ArrayList<Todo> todoArrayList, Context context) {
        this.todoArrayList = todoArrayList;
        this.context = context;
    }

    ArrayList<Todo> todoArrayList;
    Context context;

    public void updateTodo(ArrayList<Todo> todoArrayList)
    {
        this.todoArrayList=todoArrayList;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_todo,parent,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo thisTodo=todoArrayList.get(position);
        holder.tvTodoTitle.setText(thisTodo.getTitle());
        if(thisTodo.getCompleted()==true)
        {
            holder.cbTodoCompleted.setChecked(true);
        }
        else
            holder.cbTodoCompleted.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTodoTitle;
        CheckBox cbTodoCompleted;

        public TodoViewHolder(View itemView) {
            super(itemView);
            tvTodoTitle= (TextView) itemView.findViewById(R.id.tvTodoTitle);
            cbTodoCompleted= (CheckBox) itemView.findViewById(R.id.cbTodo);
        }
    }
}