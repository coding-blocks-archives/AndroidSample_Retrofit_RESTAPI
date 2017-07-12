package com.codingblocks.restapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.models.Post;

import java.util.ArrayList;

/**
 * Created by championswimmer on 12/07/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private ArrayList<Post> posts;

    public PostsAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new PostViewHolder(li.inflate(R.layout.list_item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindView(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvPostTitle, tvPostBody;

        PostViewHolder(View itemView) {
            super(itemView);
            tvPostBody = (TextView) itemView.findViewById(R.id.tvPostBody);
            tvPostTitle = (TextView) itemView.findViewById(R.id.tvPostTitle);
        }
        void bindView (Post post) {
            tvPostTitle.setText(post.getTitle());
            tvPostBody.setText(post.getBody());
        }
    }
}
