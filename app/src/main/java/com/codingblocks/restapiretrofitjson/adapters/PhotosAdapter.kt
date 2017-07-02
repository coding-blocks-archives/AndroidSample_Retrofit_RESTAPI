package com.codingblocks.restapiretrofitjson.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.interfaces.OnPhotoClickListener
import com.codingblocks.restapiretrofitjson.models.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_photos.view.*
import java.util.*

/**
 * Created by pervy_sage on 30/6/17.
 */

class PhotosAdapter(internal var photos: ArrayList<Photos>, internal var mContext: Context) : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    internal var onPhotoClickListener: OnPhotoClickListener? = null
    fun setOnPhotoClickListener(onPhotoClickListener: OnPhotoClickListener) {
        this.onPhotoClickListener = onPhotoClickListener
    }

    fun updateAlbums(photos: ArrayList<Photos>, progressBar: ProgressBar) {
        this.photos = photos
        progressBar.visibility = View.INVISIBLE
        progressBar.visibility = View.GONE
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val li = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_photos, parent, false)
        return PhotosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bindPhoto(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotosViewHolder(internal var rootView: View)
        : RecyclerView.ViewHolder(rootView) {
        fun bindPhoto(thisPhoto : Photos){
            rootView.tvTitle.text=thisPhoto.title
            Picasso.with(mContext)
                    .load(thisPhoto.thumbnailUrl)
                    .error(R.drawable.loading)
                    .placeholder(R.drawable.loading)
                    .into(rootView.ivThumbnail)
            rootView.setOnClickListener {
                onPhotoClickListener!!.onClick(thisPhoto.thumbnailUrl,thisPhoto.title)
            }
        }
    }
}
