package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Post
import kotlinx.android.synthetic.main.list_item_post.view.*

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
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_post, parent, false)

        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts!![position])
    }

    override fun getItemCount(): Int {
        return (posts?.size ?: 0)
    }

    inner class PostViewHolder(val postView: View) : RecyclerView.ViewHolder(postView) {

        fun bindView(post: Post) {
            postView.tvPostTitle.text = post.title
            postView.tvPostBody.text = post.body
        }
    }
}
