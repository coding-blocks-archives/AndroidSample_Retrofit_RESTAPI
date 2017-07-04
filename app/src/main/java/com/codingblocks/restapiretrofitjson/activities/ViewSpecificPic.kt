package com.codingblocks.restapiretrofitjson.activities

/**
 * Created by Arunima Mitra on 03-07-2017.
 */

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.codingblocks.restapiretrofitjson.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_specific_pic.*

class ViewSpecificPic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific_pic)
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")

        supportActionBar!!.title = "View Photo"

        tvTitle.text = title
        Picasso.with(this).load(url)
                .into(ivImage)
    }
}