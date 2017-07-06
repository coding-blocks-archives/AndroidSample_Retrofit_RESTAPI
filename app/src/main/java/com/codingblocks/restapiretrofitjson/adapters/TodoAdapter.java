package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Todo;

import java.util.ArrayList;


/**
 * Created by championswimmer on 02/07/17.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodosViewHolder> {

    Context context;
    ArrayList<Todo> todosArrayList;

    public TodoAdapter(Context context, ArrayList<Todo> todosArrayList) {
        this.context = context;
        this.todosArrayList = todosArrayList;
    }

    public void updateTodos(ArrayList<Todo> newTodoList){
        this.todosArrayList=newTodoList;
        notifyDataSetChanged();
    }

    @Override
    public TodosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_todo,parent,false);
        return new TodosViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(TodosViewHolder holder, int position) {
        Todo thisTodo=todosArrayList.get(position);
        holder.tvTodoTitle.setText(thisTodo.getTitle());
        if(thisTodo.getCompleted()==true){
            holder.cbTodoTask.setChecked(true);
        }
        else{
            holder.cbTodoTask.setChecked(false);
        }

    }

    @Override
    public int getItemCount()
    {
        return todosArrayList.size();
    }

    class TodosViewHolder extends RecyclerView.ViewHolder{
        TextView tvTodoTitle;
        CheckBox cbTodoTask;
        public TodosViewHolder(View itemView){
            super(itemView);
            tvTodoTitle=(TextView)itemView.findViewById(R.id.tvTodoTitle);
            cbTodoTask=(CheckBox) itemView.findViewById(R.id.cbTodoTask);

        }

    }
}