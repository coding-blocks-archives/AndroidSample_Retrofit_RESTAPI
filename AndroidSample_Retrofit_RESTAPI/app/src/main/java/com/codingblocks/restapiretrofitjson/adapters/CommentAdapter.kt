package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.models.Comment
import kotlinx.android.synthetic.main.list_item_comment.view.*
import java.util.*

/**
 * Created by championswimmer on 29/06/17.
 */

class CommentAdapter(private val context: Context,
                     private var comments: ArrayList<Comment>)
    : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    fun updateComments(comments: ArrayList<Comment>) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {


        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_comment, parent, false)

        return CommentViewHolder(
                itemView.tvCommentBody,
                itemView.tvCommentName,
                itemView.tvCommentEmail,
                itemView
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {

        val (_, _, name, email, body) = comments[position]
        holder.tvCommentBody.text = body
        holder.tvCommentName.text = name
        holder.tvCommentEmail.text = email

    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(
            public val tvCommentBody: TextView,
            public val tvCommentName: TextView,
            public val tvCommentEmail: TextView,
            itemView: View
    ) : RecyclerView.ViewHolder(itemView) {


    }
}
