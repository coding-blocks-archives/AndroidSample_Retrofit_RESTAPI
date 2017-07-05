package com.example.dell.myappl11assign.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.myappl11assign.PostsActivity;
import com.example.dell.myappl11assign.R;
import com.example.dell.myappl11assign.TodosActivity;
import com.example.dell.myappl11assign.UsersActivity;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.User;

import java.util.ArrayList;

/**
 * Created by dell on 01-07-2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    public static final String TAG = "UserAdapter";
    private Context context;
    private ArrayList<User> users;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    public void updateUsers(ArrayList<User> newUserList) {
        this.users = newUserList;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_user, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User thisUser = users.get(position);
        holder.tvUserUserName.setText(thisUser.getUsername());
        holder.tvUserName.setText(thisUser.getName());
        holder.tvUserPhone.setText(thisUser.getPhone());
        holder.tvUserEmail.setText(thisUser.getEmail());
        holder.btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: **************   Reaching POST");
                
                Intent postActIntent = new Intent(view.getContext(),PostsActivity.class);
                postActIntent.putExtra("userId", thisUser.getId());
                view.getContext().startActivity(postActIntent);
            }
        });
        holder.btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: *****************  Reaching TODO");

                Intent todoActIntent=new Intent(view.getContext(), TodosActivity.class);
                todoActIntent.putExtra("userId",thisUser.getId());
                view.getContext().startActivity(todoActIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserUserName, tvUserName, tvUserPhone, tvUserEmail;
        Button btnPosts, btnTodos;
        View thisView;

        public UserViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvUserUserName = (TextView) itemView.findViewById(R.id.tvUserUsername);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserPhone = (TextView) itemView.findViewById(R.id.tvUserPhone);
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            btnPosts = (Button) itemView.findViewById(R.id.btnPosts);
            btnTodos = (Button) itemView.findViewById(R.id.btnTodos);
        }
    }
}
