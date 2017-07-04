package com.codingblocks.restapiretrofitjson.adapters

/**
 * Created by Arunima Mitra on 03-07-2017.
 */
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.ClickOnPicListener

import com.codingblocks.restapiretrofitjson.models.Pic

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_pics.view.*
import java.util.*

/**
 * Created by pervy_sage on 30/6/17.
 */

class PicsAdapter(internal var photos: ArrayList<Pic>, internal var mContext: Context) : RecyclerView.Adapter<PicsAdapter.PicsViewHolder>() {

    internal var onPhotoClickListener: ClickOnPicListener? = null
    fun setOnPhotoClickListener(onPhotoClickListener: ClickOnPicListener) {
        this.onPhotoClickListener = onPhotoClickListener
    }

    fun updateAlbums(photos: ArrayList<Pic>, progressBar: ProgressBar) {
        this.photos = photos
        progressBar.visibility = View.INVISIBLE
        progressBar.visibility = View.GONE
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicsViewHolder {
        val li = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_pics, parent, false)
        return PicsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PicsViewHolder, position: Int) {
        holder.bindPhoto(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PicsViewHolder(internal var rootView: View)
        : RecyclerView.ViewHolder(rootView) {
        fun bindPhoto(thisPhoto : Pic){
            rootView.tvTitle.text=thisPhoto.title
            Picasso.with(mContext)
                    .load(thisPhoto.thumbnailUrl)
                    .into(rootView.ivThumbnail)
            rootView.setOnClickListener {
                ClickOnPicListener { url, title ->  }!!.onClick(thisPhoto.thumbnailUrl,thisPhoto.title)
            }
        }
    }
}