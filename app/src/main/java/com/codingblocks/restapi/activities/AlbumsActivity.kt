package com.codingblocks.restapi.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.api.Client
import com.codingblocks.restapi.models.Album
import com.codingblocks.restapi.utils.kotlin.callback
import com.codingblocks.restapi.utils.kotlin.createAdapter
import kotlinx.android.synthetic.main.activity_albums.*
import kotlinx.android.synthetic.main.list_item_album.*
import kotlinx.android.synthetic.main.list_item_album.view.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        //var albumsAdapter = AlbumsAdapter(ArrayList<Album>())

        rvAlbumsList.layoutManager = LinearLayoutManager(this)
        var albumList = ArrayList<Album>()

        rvAlbumsList.adapter = createAdapter<Album>({ album, view ->
            view.tvAlbumTitle.text = album.title
        }, R.layout.list_item_album, albumList)


        Client.getInstance().api.albums.enqueue(callback { throwable, response ->
            response?.body()?.let {
                albumList.clear()
                albumList.addAll(it)
                rvAlbumsList.adapter.notifyDataSetChanged()
            }
        })
    }
}
