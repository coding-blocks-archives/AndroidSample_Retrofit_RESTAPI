package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.PostsAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Post
import kotlinx.android.synthetic.main.activity_posts.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        val postsAdapter = PostsAdapter(ArrayList<Post>())

        rvPostsList.layoutManager = LinearLayoutManager(this)
        rvPostsList.adapter = postsAdapter

        Client.api.posts.enqueue(object : Callback<ArrayList<Post>> {
            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                postsAdapter.setPosts(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        })
    }
}
