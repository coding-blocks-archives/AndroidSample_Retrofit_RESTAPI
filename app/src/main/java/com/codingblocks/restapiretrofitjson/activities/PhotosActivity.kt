package com.codingblocks.restapiretrofitjson.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.PhotosAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.interfaces.OnPhotoClickListener
import com.codingblocks.restapiretrofitjson.models.Photos
import kotlinx.android.synthetic.main.activity_photos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PhotosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        rvPhotosView.layoutManager = LinearLayoutManager(this)
        val photosAdapter = PhotosAdapter(ArrayList<Photos>(), this)
        rvPhotosView.adapter = photosAdapter
        pbProgress.visibility = View.VISIBLE

        photosAdapter.setOnPhotoClickListener(OnPhotoClickListener { url, title ->
            val i = Intent(this@PhotosActivity, ViewPhotoActivity::class.java)
            i.putExtra("url", url)
            i.putExtra("title", title)
            startActivity(i)
        })

        val receivedId = intent.getIntExtra("albumId", -1)

        supportActionBar!!.title = "Photos"

        val photosApi = API.getInstance().photosApi

        val receivePhotos = object : Callback<ArrayList<Photos>> {
            override fun onResponse(call: Call<ArrayList<Photos>>, response: Response<ArrayList<Photos>>) {
                photosAdapter.updateAlbums(response.body()!!, pbProgress)
            }

            override fun onFailure(call: Call<ArrayList<Photos>>, t: Throwable) {

            }
        }
        if (receivedId != -1) {
            photosApi.getPhotosOfAlbumId(receivedId).enqueue(receivePhotos)
        } else {
            photosApi.photos.enqueue(receivePhotos)
        }
    }
}
