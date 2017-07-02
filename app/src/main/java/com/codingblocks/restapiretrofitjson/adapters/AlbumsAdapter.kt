package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Album
import kotlinx.android.synthetic.main.list_item_album.view.*
import java.util.*

/**
 * Created by pervy_sage on 30/6/17.
 */

class AlbumsAdapter(internal var albums: ArrayList<Album>, internal var mContext: Context) : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    internal var onItemClickListener: OnItemClickListener? = null
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun updateAlbums(albums: ArrayList<Album>, progressBar: ProgressBar) {

        this.albums = albums
        progressBar.visibility = View.INVISIBLE
        progressBar.visibility = View.GONE
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val li = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_album, parent, false)
        return AlbumsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bindAlbum(albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    inner class AlbumsViewHolder(internal var rootView: View)
        : RecyclerView.ViewHolder(rootView) {
       fun bindAlbum(thisAlbum : Album){
           rootView.tvTitle.text=thisAlbum.title
           rootView.setOnClickListener {
               onItemClickListener!!.onItemClick(thisAlbum.id,rootView)
           }
       }
    }
}
