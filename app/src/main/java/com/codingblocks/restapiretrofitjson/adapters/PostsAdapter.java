package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.Post;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private ArrayList<Post> postList;
    private final Context context;
    private OnButtonClickListener onButtonClickListener;
    public PostsAdapter(ArrayList<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }
    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public void updateList(ArrayList<Post> postList){
        this.postList = postList;
        notifyDataSetChanged();
    }

    @Override
    public PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_posts,parent,false);
        return new PostsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostsViewHolder holder, int position) {

        final Post post = postList.get(position);
        holder.tvPostTitle.setText(post.getTitle());
        holder.tvPostBody.setText(post.getBody());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onButtonClickListener!=null){
                    onButtonClickListener.onButtonClicked(post.getId(),0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{
        final TextView tvPostTitle;
        final TextView tvPostBody;
        final View rootView;
        public PostsViewHolder(View itemView) {
            super(itemView);
            tvPostTitle = itemView.findViewById(R.id.tv_PostTitle);
            tvPostBody = itemView.findViewById(R.id.tv_PostBody);
            rootView = itemView;
        }
    }
}
