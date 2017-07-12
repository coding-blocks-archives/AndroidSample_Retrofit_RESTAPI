package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Post

import java.util.ArrayList

/**
 * Created by championswimmer on 12/07/17.
 */

class PostsAdapter(private var posts: ArrayList<Post>?) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    fun setPosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val li = LayoutInflater.from(parent.context)
        return PostViewHolder(li.inflate(R.layout.list_item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts!![position])
    }

    override fun getItemCount(): Int {
        return (posts?.size ?: 0)
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPostTitle: TextView
        var tvPostBody: TextView

        init {
            tvPostBody = itemView.findViewById<View>(R.id.tvPostBody) as TextView
            tvPostTitle = itemView.findViewById<View>(R.id.tvPostTitle) as TextView
        }

        fun bindView(post: Post) {
            tvPostTitle.text = post.title
            tvPostBody.text = post.body
        }
    }
}
