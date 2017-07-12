package com.codingblocks.restapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.models.User;

import java.util.ArrayList;

/**
 * Created by championswimmer on 12/07/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private ArrayList<User> users;

    public UsersAdapter(ArrayList<User> users) {
        this.users = users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new UserViewHolder(li.inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName, tvUserUsername, tvUserPhone, tvUserEmail;

        UserViewHolder(View itemView) {
            super(itemView);
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            tvUserUsername = (TextView) itemView.findViewById(R.id.tvUserUsername);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserPhone = (TextView) itemView.findViewById(R.id.tvUserPhone);
        }

        void bindView (User user) {
            tvUserPhone.setText(user.getName());
            tvUserEmail.setText(user.getEmail());
            tvUserUsername.setText(user.getUsername());
            tvUserName.setText(user.getName());
        }
    }
}
