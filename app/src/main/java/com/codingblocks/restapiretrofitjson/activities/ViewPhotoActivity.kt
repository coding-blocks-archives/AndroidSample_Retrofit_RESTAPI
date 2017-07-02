package com.codingblocks.restapiretrofitjson.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codingblocks.restapiretrofitjson.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_view_photo.*

class ViewPhotoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_photo)
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")

        supportActionBar!!.title = "View Photo"

        tvTitle.text = title
        Picasso.with(this).load(url).error(R.drawable.loading)
                .placeholder(R.drawable.loading)
                .into(ivImage)
    }
}
