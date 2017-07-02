package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Post
import kotlinx.android.synthetic.main.list_item_post.view.*
import java.util.*

/**
 * Created by championswimmer on 29/06/17.
 */

internal class PostAdapter(private val context: Context, private var posts: ArrayList<Post>?) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun updatePosts(posts: ArrayList<Post>, progressBar: ProgressBar) {
        this.posts = posts
        progressBar.visibility = View.INVISIBLE
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d(TAG, "onCreateViewHolder: ")
        val li = context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_post, parent, false)

        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")
        holder.bindPost(posts!![position])

    }

    override fun getItemCount(): Int {
        return posts!!.size
    }

    inner class PostViewHolder(var thisView: View)
        : RecyclerView.ViewHolder(thisView) {
        fun bindPost(thispost : Post){
            thisView.tvPostBody.text=thispost.body
            thisView.tvPostTitle.text=thispost.title
            thisView.setOnClickListener {
                onItemClickListener!!.onItemClick(thispost.id,thisView)
            }
        }
    }

    companion object {

        val TAG = "PADPTR"
    }
}
