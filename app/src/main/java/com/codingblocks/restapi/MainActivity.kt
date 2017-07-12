package com.codingblocks.restapi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

import com.codingblocks.restapi.activities.AlbumsActivity
import com.codingblocks.restapi.activities.PostsActivity
import com.codingblocks.restapi.activities.TodosActivity
import com.codingblocks.restapi.activities.UsersActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onButtonClickListener = View.OnClickListener { view ->
            var i: Intent? = null
            when (view.id) {
                R.id.btnAlbums -> i = Intent(this@MainActivity, AlbumsActivity::class.java)
                R.id.btnPosts -> i = Intent(this@MainActivity, PostsActivity::class.java)
                R.id.btnTodos -> i = Intent(this@MainActivity, TodosActivity::class.java)
                R.id.btnUsers -> i = Intent(this@MainActivity, UsersActivity::class.java)
            }
            startActivity(i)
        }

        btnTodos.setOnClickListener(onButtonClickListener)
        btnAlbums.setOnClickListener(onButtonClickListener)
        btnPosts.setOnClickListener(onButtonClickListener)
        btnUsers.setOnClickListener(onButtonClickListener)

    }
}
