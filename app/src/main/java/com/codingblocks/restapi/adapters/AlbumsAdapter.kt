package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Album

import kotlinx.android.synthetic.main.list_item_album.view.*

import java.util.ArrayList

/**
 * Created by championswimmer on 12/07/17.
 */

class AlbumsAdapter(private var albums: ArrayList<Album>?) : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    fun setAlbums(albums: ArrayList<Album>) {
        this.albums = albums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_album, parent, false)

        return AlbumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindView(albums!![position])
    }

    override fun getItemCount(): Int {
        return (albums?.size ?: 0)
    }

    inner class AlbumViewHolder(val albumView: View) : RecyclerView.ViewHolder(albumView) {


        fun bindView(album: Album) {
            albumView.tvAlbumTitle.text = album.title
        }
    }
}
