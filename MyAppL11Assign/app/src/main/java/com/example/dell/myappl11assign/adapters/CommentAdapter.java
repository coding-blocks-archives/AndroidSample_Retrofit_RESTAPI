package com.example.dell.myappl11assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.myappl11assign.R;
import com.example.dell.myappl11assign.models.Comment;

import java.util.ArrayList;

/**
 * Created by dell on 01-07-2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    public static final String TAG = "CommentAdapter";
    private Context context;
    private ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    public void updateComments(ArrayList<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_comment, parent, false);
        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment thisComment = comments.get(position);
        holder.tvCommentBody.setText(thisComment.getBody());
        holder.tvCommentEmail.setText(thisComment.getEmail());
        holder.tvCommentName.setText(thisComment.getName());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView tvCommentBody, tvCommentName, tvCommentEmail;

        public CommentViewHolder(View itemView) {
            super(itemView);
            tvCommentBody = (TextView) itemView.findViewById(R.id.tvCommentBody);
            tvCommentEmail = (TextView) itemView.findViewById(R.id.tvCommentEmail);
            tvCommentName = (TextView) itemView.findViewById(R.id.tvCommentName);
        }
    }
}
