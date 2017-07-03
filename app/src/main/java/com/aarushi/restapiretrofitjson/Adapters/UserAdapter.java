package com.aarushi.restapiretrofitjson.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.User;
import com.aarushi.restapiretrofitjson.R;

import java.util.ArrayList;

/**
 * Created by hp on 7/1/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    Context context;
    ArrayList<User> userArrayList;

    private OnItemClickListener oicl,oicl1;


    public void setOnItemClickListener(OnItemClickListener oicl){
        this.oicl=oicl;
    }
    public void setOnItemClickListener1(OnItemClickListener oicl1){
        this.oicl1=oicl1;
    }

    public UserAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    public void updateUsers(ArrayList<User> newUserList){
        this.userArrayList=newUserList;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_user,parent,false);
        return new UserViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        User thisUser=userArrayList.get(position);
        holder.tvUserUserName.setText(thisUser.getUsername());
        holder.tvUserName.setText(thisUser.getName());
        holder.tvUserPhone.setText(thisUser.getPhone());
        holder.tvUserEmail.setText(thisUser.getEmail());
        holder.btnUserPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl.OnItemClick(position);
                }
            }
        });
        holder.btnUserComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl1.OnItemClick(position);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvUserUserName,tvUserName,tvUserPhone,tvUserEmail;
        Button btnUserPosts,btnUserComments;
        public UserViewHolder(View itemView){
            super(itemView);
            tvUserUserName=(TextView)itemView.findViewById(R.id.tvUserUserName);
            tvUserName=(TextView)itemView.findViewById(R.id.tvUserName);
            tvUserPhone=(TextView)itemView.findViewById(R.id.tvUserPhone);
            tvUserEmail=(TextView)itemView.findViewById(R.id.tvUserEmail);
            btnUserPosts=(Button)itemView.findViewById(R.id.btnUserPosts);
            btnUserComments=(Button)itemView.findViewById(R.id.btnUserComments);
        }

    }

}
