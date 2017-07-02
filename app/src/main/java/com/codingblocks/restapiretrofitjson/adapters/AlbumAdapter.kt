package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Album
import kotlinx.android.synthetic.main.list_item_album.view.*

/**
 * Created by abheisenberg on 2/7/17.
 */

class AlbumAdapter (private val context: Context,
                    private var albumsList: ArrayList<Album>?)
    : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {

    internal var onItemClickListener : OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun updateAdapter(newAlbumList: ArrayList<Album>) {
        this.albumsList = newAlbumList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AlbumHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_album, parent, false)
        return AlbumHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumHolder?, position: Int) {
        holder?.BindAlbum(albumsList!![position])
    }

    override fun getItemCount(): Int {
        return albumsList!!.size
    }

    inner class AlbumHolder (public var thisView: View)
        : RecyclerView.ViewHolder(thisView) {

        fun BindAlbum(album: Album) {
            thisView.tvAlbumTitle.text = album.title
            thisView.setOnClickListener {
                onItemClickListener?.onItemClick(album.id
                , thisView)
            }
        }
    }

}