package com.codingblocks.restapi.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.codingblocks.restapi.R
import com.codingblocks.restapi.models.Album

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
        val li = LayoutInflater.from(parent.context)
        return AlbumViewHolder(li.inflate(R.layout.list_item_album, parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindView(albums!![position])
    }

    override fun getItemCount(): Int {
        return (albums?.size ?: 0)
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAlbumTitle: TextView

        init {
            tvAlbumTitle = itemView.findViewById<View>(R.id.tvAlbumTitle) as TextView
        }

        fun bindView(album: Album) {
            tvAlbumTitle.text = album.title
        }
    }
}
