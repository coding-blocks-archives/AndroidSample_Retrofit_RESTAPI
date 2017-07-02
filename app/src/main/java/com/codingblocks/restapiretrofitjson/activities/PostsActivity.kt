package com.codingblocks.restapiretrofitjson.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.PostAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Post
import kotlinx.android.synthetic.main.activity_posts.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        rvPostsList.layoutManager = LinearLayoutManager(this)
        val postAdapter = PostAdapter(this, ArrayList<Post>())
        rvPostsList.adapter = postAdapter
        pbProgress.visibility = View.VISIBLE
        postAdapter.setOnItemClickListener(OnItemClickListener { itemId, view ->
            val i = Intent(this@PostsActivity, CommentsActivity::class.java)
            i.putExtra("postId", itemId)
            startActivity(i)
        })


        val postsAPI = API.getInstance().postsAPI
        val postCallback = object : Callback<ArrayList<Post>> {

            override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                Log.d(TAG, "onResponse: ")
                postAdapter.updatePosts(response.body()!!, pbProgress)
            }

            override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

            }
        }
        val userIdReceived = intent.getIntExtra("userId", -1)
        val username = intent.getStringExtra("username")
        if (userIdReceived != -1) {
            postsAPI.getPostsByUserId(userIdReceived).enqueue(postCallback)
            supportActionBar!!.title = "Posts by " + username
        } else {
            postsAPI.posts.enqueue(postCallback)
            supportActionBar!!.title = "Posts"
        }

    }

    companion object {

        val TAG = "PA"
    }
}
