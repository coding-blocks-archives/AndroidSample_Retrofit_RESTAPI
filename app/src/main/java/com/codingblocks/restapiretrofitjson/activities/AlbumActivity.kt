package com.codingblocks.restapiretrofitjson.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.adapters.AlbumsAdapter
import com.codingblocks.restapiretrofitjson.api.API
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Album
import kotlinx.android.synthetic.main.activity_album.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class AlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        rvAlbumsView.layoutManager = LinearLayoutManager(this)
        val albumsAdapter = AlbumsAdapter(ArrayList<Album>(), this)
        rvAlbumsView.adapter = albumsAdapter
        pbProgress.visibility = View.VISIBLE
        btnShowAllPhotos.setOnClickListener { startActivity(Intent(this@AlbumActivity, PhotosActivity::class.java)) }
        albumsAdapter.setOnItemClickListener(OnItemClickListener { itemid, view ->
            val i = Intent(this@AlbumActivity, PhotosActivity::class.java)
            i.putExtra("albumId", itemid)
            startActivity(i)
        })
        val receivedId = intent.getIntExtra("userId", -1)
        supportActionBar!!.title = "Albums"
        val albumsApi = API.getInstance().albumsApi
        val receiveAlbums = object : Callback<ArrayList<Album>> {
            override fun onResponse(call: Call<ArrayList<Album>>, response: Response<ArrayList<Album>>) {
                albumsAdapter.updateAlbums(response.body()!!, pbProgress)
            }

            override fun onFailure(call: Call<ArrayList<Album>>, t: Throwable) {

            }
        }

        if (receivedId != -1) {
            albumsApi.getAlbumsbyUserId(receivedId).enqueue(receiveAlbums)
        } else {
            albumsApi.getAlbumsbyUserId(null).enqueue(receiveAlbums)
        }

    }
}
