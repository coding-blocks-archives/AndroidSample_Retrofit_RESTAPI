package com.aarushi.restapiretrofitjson.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.Models.User;
import com.aarushi.restapiretrofitjson.R;

import java.util.ArrayList;

/**
 * Created by hp on 7/1/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{
    Context context;
    ArrayList<Post> postArrayList;

    OnItemClickListener oicl;
    public void setOnItemClickListener(OnItemClickListener oicl){
        this.oicl=oicl;
    }

    public PostsAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    public void updatePosts(ArrayList<Post> newPostList){
        this.postArrayList=newPostList;
        notifyDataSetChanged();
    }

    @Override
    public PostsAdapter.PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_post,parent,false);
        return new PostsAdapter.PostViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PostsAdapter.PostViewHolder holder, final int position) {
        Post thisPost=postArrayList.get(position);
        holder.tvPostTitle.setText(thisPost.getTitle());
        holder.tvPostBody.setText(thisPost.getBody());
        holder.btnPostComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl.OnItemClick(position+1);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return postArrayList.size();
    }




    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tvPostTitle,tvPostBody;
        Button btnPostComments;
        public PostViewHolder(View itemView){
            super(itemView);
            tvPostTitle=(TextView)itemView.findViewById(R.id.tvPostTitle);
            tvPostBody=(TextView)itemView.findViewById(R.id.tvPostBody);
            btnPostComments=(Button)itemView.findViewById(R.id.btnPostComments);
        }

    }
}
