package com.codingblocks.restapiretrofitjson

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codingblocks.restapiretrofitjson.activities.AlbumActivity
import com.codingblocks.restapiretrofitjson.activities.PostsActivity
import com.codingblocks.restapiretrofitjson.activities.TodosActivity
import com.codingblocks.restapiretrofitjson.activities.UsersActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.btnAlbums->startActivity(Intent(this@MainActivity,AlbumActivity::class.java))
            R.id.btnPosts->startActivity(Intent(this@MainActivity,PostsActivity::class.java))
            R.id.btnUsers->startActivity(Intent(this@MainActivity,UsersActivity::class.java))
            R.id.btnTodos->startActivity(Intent(this@MainActivity,TodosActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlbums.setOnClickListener(this)
        btnPosts.setOnClickListener(this)
        btnUsers.setOnClickListener(this)
        btnTodos.setOnClickListener(this)
    }
}
