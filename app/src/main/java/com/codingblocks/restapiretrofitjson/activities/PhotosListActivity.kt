package com.codingblocks.restapiretrofitjson.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_photos_list.*

import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.PhotoListAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos_list)

        var photoListAdapter : PhotoListAdapter = PhotoListAdapter(this, ArrayList<Photo>())

        rvPhotosList.layoutManager = LinearLayoutManager(this)
        rvPhotosList.adapter = photoListAdapter

        var photoListCallback = object: Callback<ArrayList<Photo>> {
            override fun onResponse(call: Call<ArrayList<Photo>>?, response: Response<ArrayList<Photo>>?) {
                photoListAdapter.updatePhotos(response?.body())
            }

            override fun onFailure(call: Call<ArrayList<Photo>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        API.getInstance().photoAPI.getPhotosOfAlbumId(intent.getIntExtra("albumId",-1))
                .enqueue(photoListCallback)
    }
}
