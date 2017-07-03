package com.aarushi.restapiretrofitjson.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aarushi.restapiretrofitjson.Models.Comment;
import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.R;

import java.util.ArrayList;

/**
 * Created by hp on 7/2/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>{


    Context context;
    ArrayList<Comment> commentArrayList;

    public CommentsAdapter(Context context, ArrayList<Comment> commentArrayList) {
        this.context = context;
        this.commentArrayList = commentArrayList;
    }

    public void updateComments(ArrayList<Comment> newCommentList){
        this.commentArrayList=newCommentList;
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_comment,parent,false);
        return new CommentViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment thisComment=commentArrayList.get(position);
        holder.tvCommentBody.setText(thisComment.getBody());
        holder.tvCommentEmail.setText(thisComment.getEmail());
        holder.tvCommentName.setText(thisComment.getName());

    }


    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView tvCommentBody,tvCommentEmail,tvCommentName;
        public CommentViewHolder(View itemView){
            super(itemView);
            tvCommentBody=(TextView)itemView.findViewById(R.id.tvCommentBody);
            tvCommentEmail=(TextView)itemView.findViewById(R.id.tvCommentEmail);
            tvCommentName=(TextView)itemView.findViewById(R.id.tvCommentName);


        }

    }


}
