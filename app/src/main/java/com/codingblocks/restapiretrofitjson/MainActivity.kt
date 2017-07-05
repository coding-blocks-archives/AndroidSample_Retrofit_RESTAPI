package com.codingblocks.restapiretrofitjson


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.restapiretrofitjson.activities.AlbumActivity
import com.codingblocks.restapiretrofitjson.activities.PostsActivity
import com.codingblocks.restapiretrofitjson.activities.TodosActivity
import com.codingblocks.restapiretrofitjson.activities.UsersActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPosts.setOnClickListener({
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
        })

        btnUsers.setOnClickListener({
            startActivity(Intent(this@MainActivity, UsersActivity::class.java))
        })

        btnTodos.setOnClickListener({
            startActivity(Intent(this@MainActivity, TodosActivity::class.java))
        })
        btnAlbums.setOnClickListener({
            startActivity(Intent(this@MainActivity, AlbumActivity::class.java))
        })


    }
}