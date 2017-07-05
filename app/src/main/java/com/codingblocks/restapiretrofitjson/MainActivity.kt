package com.codingblocks.restapiretrofitjson

import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.restapiretrofitjson.activities.AlbumsActivity
import com.codingblocks.restapiretrofitjson.activities.PostsActivity
import com.codingblocks.restapiretrofitjson.activities.TodosActivity
import com.codingblocks.restapiretrofitjson.activities.UsersActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            window.setStatusBarColor(getResources().getColor(R.color.colorMain))
        getSupportActionBar()?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.colorMain)))

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
            startActivity(Intent(this@MainActivity, AlbumsActivity::class.java))
        })
    }
}
