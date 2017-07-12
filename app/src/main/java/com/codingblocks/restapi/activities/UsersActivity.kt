package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.UsersAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.User

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {
    internal var rvUsersList: RecyclerView
    internal var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        rvUsersList = findViewById(R.id.rvUsersList) as RecyclerView
        rvUsersList.layoutManager = LinearLayoutManager(this)
        usersAdapter = UsersAdapter(ArrayList<User>())
        rvUsersList.adapter = usersAdapter

        Client.getInstance().api.users.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                usersAdapter.setUsers(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

            }
        })
    }
}
