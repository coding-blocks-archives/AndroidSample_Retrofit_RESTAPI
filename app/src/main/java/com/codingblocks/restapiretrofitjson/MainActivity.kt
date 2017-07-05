package com.codingblocks.restapiretrofitjson

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codingblocks.restapiretrofitjson.activities.AlbumActivity
import com.codingblocks.restapiretrofitjson.activities.PostsActivity
import com.codingblocks.restapiretrofitjson.activities.TodosActivity
import com.codingblocks.restapiretrofitjson.activities.UsersActivity
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.with(this@MainActivity).load("https://cdn0.iconfinder.com/data/icons/large-glossy-icons/512/Large_group.png").into(ivUsers)
        Picasso.with(this@MainActivity).load("http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/post-it-icon.png").into(ivPosts)
        Picasso.with(this@MainActivity).load("https://droidveda.com/ij/wp-content/uploads/2013/09/album-maker-icon.png").into(ivAlbums)
        Picasso.with(this@MainActivity).load("https://xinote.com/application/web/views/templates/xiview/images/home/todolist_icon.png").into(ivTodos)

        ivUsers.setOnClickListener({
            startActivity(Intent(this@MainActivity, UsersActivity::class.java))
        })

        ivPosts.setOnClickListener({
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
        })

        ivAlbums.setOnClickListener({
            startActivity(Intent(this@MainActivity, AlbumActivity::class.java))
        })

        ivTodos.setOnClickListener({
            startActivity(Intent(this@MainActivity, TodosActivity::class.java))
        })


    }
}
