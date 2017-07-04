package com.codingblocks.restapiretrofitjson.activities

/**
 * Created by Arunima Mitra on 03-07-2017.
 */

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.PicsAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.interfaces.ClickOnPicListener

import com.codingblocks.restapiretrofitjson.models.Pic

import kotlinx.android.synthetic.main.activity_pics.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PicsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pics)
        rvPhotosView.layoutManager = LinearLayoutManager(this)
        val photosAdapter = PicsAdapter(ArrayList<Pic>(), this)
        rvPhotosView.adapter = photosAdapter
        pbProgress.visibility = View.VISIBLE

        photosAdapter.setOnPhotoClickListener(ClickOnPicListener { url, title ->
            val i = Intent(this@PicsActivity, ViewSpecificPic::class.java)
            i.putExtra("url", url)
            i.putExtra("title", title)
            startActivity(i)
        })

        val receivedId = intent.getIntExtra("albumId", -1)

        supportActionBar!!.title = "Photos"

        val photosApi = API.getInstance().photosApi

        val receivePhotos = object : Callback<ArrayList<Pic>> {
            override fun onResponse(call: Call<ArrayList<Pic>>, response: Response<ArrayList<Pic>>) {
                photosAdapter.updateAlbums(response.body()!!, pbProgress)
            }

            override fun onFailure(call: Call<ArrayList<Pic>>, t: Throwable) {

            }
        }
        if (receivedId != -1) {
            photosApi.getPhotosOfAlbumId(receivedId).enqueue(receivePhotos)
        } else {
            photosApi.photos.enqueue(receivePhotos)
        }
    }
}