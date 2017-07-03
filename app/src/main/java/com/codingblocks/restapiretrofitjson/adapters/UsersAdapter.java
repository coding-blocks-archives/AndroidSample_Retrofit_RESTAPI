package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.User;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    public static final int POST_BUTTON =1,TODO_BUTTON=2;

    private ArrayList<User> userList;
    private final Context context;
    private OnButtonClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public UsersAdapter(ArrayList userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    public void updateList(ArrayList<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    // test
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_users,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User user = userList.get(position);
        holder.tvUser.setText(user.getUsername());
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());
        holder.tvPhone.setText(user.getPhone());
        holder.btnUserPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onButtonClickListener!=null){
                    onButtonClickListener.onButtonClicked(user.getId(),POST_BUTTON);
                }
            }
        });
        holder.btnUserTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onButtonClickListener!=null){
                    onButtonClickListener.onButtonClicked(user.getId(),TODO_BUTTON);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        final TextView tvUser;
        final TextView tvName;
        final TextView tvPhone;
        final TextView tvEmail;
        final Button btnUserPosts;
        final Button btnUserTodo;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUser);
            tvName = itemView.findViewById(R.id.tv_Name);
            tvPhone = itemView.findViewById(R.id.tv_Phone);
            tvEmail = itemView.findViewById(R.id.tv_Email);
            btnUserPosts = itemView.findViewById(R.id.btn_UserPosts);
            btnUserTodo = itemView.findViewById(R.id.btn_UserTodo);
        }
    }
}
