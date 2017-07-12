package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.adapters.AlbumsAdapter
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Album
import kotlinx.android.synthetic.main.activity_albums.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val albumsAdapter = AlbumsAdapter(ArrayList<Album>())

        rvAlbumsList.layoutManager = LinearLayoutManager(this)
        rvAlbumsList.adapter = albumsAdapter

        Client.getInstance().api.albums.enqueue(object : Callback<ArrayList<Album>> {
            override fun onResponse(call: Call<ArrayList<Album>>, response: Response<ArrayList<Album>>) {
                albumsAdapter.setAlbums(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Album>>, t: Throwable) {

            }
        })
    }
}
