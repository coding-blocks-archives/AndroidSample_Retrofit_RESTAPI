package com.codingblocks.restapiretrofitjson.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.CommentAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.models.Comment
import kotlinx.android.synthetic.main.activity_comments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val commentAdapter =  CommentAdapter(this, ArrayList<Comment>())
        rvCommentsList.layoutManager = LinearLayoutManager(this)
        rvCommentsList.adapter = commentAdapter
        pbProgress.visibility= View.VISIBLE

        supportActionBar!!.title="Comments"



        API.getInstance().commentsAPI.getCommentsByPostId(intent.getIntExtra("postId", 0))
                .enqueue(object : Callback<ArrayList<Comment>> {
            override fun onFailure(call: Call<ArrayList<Comment>>?, t: Throwable?) {
                //
            }

            override fun onResponse(call: Call<ArrayList<Comment>>?, response: Response<ArrayList<Comment>>?) {
                //
                commentAdapter.updateComments(response!!.body()!!,pbProgress)
            }
        })
    }
}
