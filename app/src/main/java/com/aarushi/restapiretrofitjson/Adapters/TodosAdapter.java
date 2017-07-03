package com.aarushi.restapiretrofitjson.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.Models.Todos;
import com.aarushi.restapiretrofitjson.R;

import java.util.ArrayList;

/**
 * Created by hp on 7/1/2017.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    Context context;
    ArrayList<Todos> todosArrayList;

    public TodosAdapter(Context context, ArrayList<Todos> todosArrayList) {
        this.context = context;
        this.todosArrayList = todosArrayList;
    }

    public void updatePosts(ArrayList<Todos> newTodoList){
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
        Todos thisTodo=todosArrayList.get(position);
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
