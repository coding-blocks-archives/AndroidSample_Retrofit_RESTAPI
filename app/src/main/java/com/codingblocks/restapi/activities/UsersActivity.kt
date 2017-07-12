package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.UsersAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.User
import com.codingblocks.restapi.utils.kotlin.callback
import kotlinx.android.synthetic.main.activity_users.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {
    internal var usersAdapter: UsersAdapter = UsersAdapter(ArrayList<User>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        rvUsersList.layoutManager = LinearLayoutManager(this)

        rvUsersList.adapter = usersAdapter

        Client.getInstance().api.users.enqueue(callback
        { throwable, response -> response?.body()?.let { usersAdapter.setUsers(it) } })
    }
}
