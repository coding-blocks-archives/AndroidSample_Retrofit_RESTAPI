package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.PostsAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Post

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsActivity : AppCompatActivity() {
    internal var rvPostsList: RecyclerView
    internal var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        rvPostsList = findViewById(R.id.rvPostsList) as RecyclerView
        postsAdapter = PostsAdapter(ArrayList<Post>())

        rvPostsList.layoutManager = LinearLayoutManager(this)
        rvPostsList.adapter = postsAdapter

        Client.getInstance().api.posts.enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                postsAdapter.setPosts(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }
}
