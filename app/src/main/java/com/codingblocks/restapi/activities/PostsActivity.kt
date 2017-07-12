package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.PostsAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Post
import com.codingblocks.restapi.utils.kotlin.callback
import kotlinx.android.synthetic.main.activity_posts.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        var postsAdapter = PostsAdapter(ArrayList<Post>())

        rvPostsList.layoutManager = LinearLayoutManager(this)
        rvPostsList.adapter = postsAdapter

        Client.getInstance().api.posts.enqueue(callback { throwable, response ->
            response?.body()?.let { postsAdapter.setPosts(it) }
        })
    }
}
