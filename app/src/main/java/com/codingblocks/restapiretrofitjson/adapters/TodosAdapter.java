package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.onTitleClickListener;
import com.codingblocks.restapiretrofitjson.models.Todos;

import java.util.ArrayList;

/**
 * Created by Harshi on 7/5/2017.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder>{

    private Context context;
    private ArrayList<Todos> todos;
    private onTitleClickListener ontitleClickListener;
    private onTitleClickListener oicl;


    public void setOnItemClickListener(onTitleClickListener oicl) {
        this.ontitleClickListener = (onTitleClickListener) oicl;
    }

    public TodosAdapter(Context context, ArrayList<Todos> todos) {
        this.context = context;
        this.todos = todos;
    }

    public void updateTodos (ArrayList<Todos> newTodosList) {
        this.todos = newTodosList;
        notifyDataSetChanged();
    }


    @Override
    public TodosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_todo, parent, false);

        return new TodosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TodosViewHolder holder, int position) {
        Todos thistodos = todos.get(position);

        holder.tvtitle.setText(thistodos.getTitle());
        holder.click.setChecked(thistodos.getCompleted());
//        holder.thisView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ontitleClickListener != null) {
//                    ontitleClickListener.OnItemClicks(thistodos.getTitle());
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodosViewHolder extends RecyclerView.ViewHolder {

        TextView tvtitle;
        CheckBox click;
        View thisView;

        public TodosViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvtitle = (TextView) itemView.findViewById(R.id.tvshowTodoTitle);
            click = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}

