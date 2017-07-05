package com.example.dell.myappl11assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.dell.myappl11assign.R;
import com.example.dell.myappl11assign.models.Todo;

import java.util.ArrayList;

/**
 * Created by dell on 01-07-2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    public static final String TAG="TodoAdapter";
    private Context context;
    private ArrayList<Todo> todos;

    public TodoAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    public void updateTodos(ArrayList<Todo>todos){
        this.todos=todos;
        notifyDataSetChanged();
    }
    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_todo,parent,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: *********************");
        Todo thisTodo=todos.get(position);
        holder.cbTodoCompleted.setChecked(thisTodo.getCompleted());
        holder.tvTodoTitle.setText(thisTodo.getTitle());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{
        CheckBox cbTodoCompleted;
        TextView tvTodoTitle;

        public TodoViewHolder(View itemView) {
            super(itemView);

            cbTodoCompleted=(CheckBox) itemView.findViewById(R.id.cbTodoCompleted);
            tvTodoTitle=(TextView) itemView.findViewById(R.id.tvTodoTitle);
        }
    }
}
