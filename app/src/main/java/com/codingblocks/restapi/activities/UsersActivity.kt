package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.UsersAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.User
import com.codingblocks.restapi.utils.rfcb
import kotlinx.android.synthetic.main.activity_users.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val usersAdapter = UsersAdapter(ArrayList<User>())

        rvUsersList.layoutManager = LinearLayoutManager(this)
        rvUsersList.adapter = usersAdapter

        Client.api.users.enqueue(rfcb { t, resp -> resp?.body()?.let { usersAdapter.setUsers(it) } })
    }
}
