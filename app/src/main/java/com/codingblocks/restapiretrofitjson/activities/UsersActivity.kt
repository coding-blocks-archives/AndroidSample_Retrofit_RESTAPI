package com.codingblocks.restapiretrofitjson.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.UserAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.models.User
import kotlinx.android.synthetic.main.activity_users.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        rvUserList.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(this, ArrayList<User>())
        rvUserList.adapter = userAdapter
        pbProgress.visibility = View.VISIBLE
        supportActionBar!!.title = "Users"

        (findViewById(R.id.btnAllPosts) as Button).setOnClickListener {
            startActivity(Intent(
                    this@UsersActivity,
                    PostsActivity::class.java
            ))
        }


        API.getInstance().usersAPI.users.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>,
                                    response: Response<ArrayList<User>>) {
                userAdapter.updateUsers(response.body()!!, pbProgress)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

            }
        })

    }

    companion object {

        val TAG = "USERS"
    }


}
