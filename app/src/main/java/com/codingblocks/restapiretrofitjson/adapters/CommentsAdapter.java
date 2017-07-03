package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Comment;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private ArrayList<Comment> commentsList;
    private final Context context;

    public CommentsAdapter(ArrayList<Comment> commentsList, Context context) {
        this.commentsList = commentsList;
        this.context = context;
    }

    public void updateList(ArrayList<Comment> commentsList){
        this.commentsList = commentsList;
        notifyDataSetChanged();
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_comments,parent,false);
        return new CommentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comment comment = commentsList.get(position);
        holder.tvCommentBody.setText(comment.getBody());
        holder.tvCommentName.setText(comment.getName());
        holder.tvCommentEmail.setText(comment.getEmail());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    class CommentsViewHolder extends RecyclerView.ViewHolder{
        final TextView tvCommentBody;
        final TextView tvCommentName;
        final TextView tvCommentEmail;
        public CommentsViewHolder(View itemView) {
            super(itemView);
            tvCommentBody = itemView.findViewById(R.id.tv_CommentBody);
            tvCommentName = itemView.findViewById(R.id.tv_CommentName);
            tvCommentEmail = itemView.findViewById(R.id.tv_CommentEmail);
        }
    }
}
