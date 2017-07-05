package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.PostsActivity;
import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.TodosActiviy;
import com.codingblocks.restapiretrofitjson.interfaces.onItemClickListener;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

/**
 * Created by Harshi on 7/5/2017.
 */

public class UserAdapter
        extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    public static final String TAG = "UA";

    private Context context;
    private ArrayList<User> users;
    private onItemClickListener oicl;
    private onItemClickListener onitemClickListener;


    public void setOnItemClickListener(onItemClickListener oicl) {
        this.onitemClickListener = oicl;
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
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        final User thisUser = users.get(position);

        holder.tvUserUsername.setText(thisUser.getUsername());
        holder.tvUserName.setText(thisUser.getName());
        holder.tvUserPhone.setText(thisUser.getPhone());
        holder.tvUserEmail.setText(thisUser.getEmail());
        holder.btnshowPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PostsActivity.class);
                i.putExtra("userId",thisUser.getId());
                context.startActivity(i);
            }
        });
        holder.btnshowTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, TodosActiviy.class);
                i.putExtra("userId",thisUser.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserUsername, tvUserName, tvUserPhone, tvUserEmail;
        View thisView;
        Button btnshowTodos, btnshowPosts;

        public UserViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserPhone = (TextView) itemView.findViewById(R.id.tvUserPhone);
            tvUserUsername = (TextView) itemView.findViewById(R.id.tvUserUsername);
            btnshowPosts = (Button) itemView.findViewById(R.id.tvUserShowPost);
            btnshowTodos = (Button) itemView.findViewById(R.id.tvUserShowTodos);
        }
    }
}
