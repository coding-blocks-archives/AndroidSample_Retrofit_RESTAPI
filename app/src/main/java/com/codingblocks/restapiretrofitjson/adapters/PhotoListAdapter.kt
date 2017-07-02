package com.codingblocks.restapiretrofitjson.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codingblocks.restapiretrofitjson.R
import com.codingblocks.restapiretrofitjson.activities.PhotoViewActivity
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener
import com.codingblocks.restapiretrofitjson.models.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_photos.view.*

/**
 * Created by abheisenberg on 2/7/17.
 */
class PhotoListAdapter (private val context: Context,
                        private var photosList: ArrayList<Photo>?
) : RecyclerView.Adapter<PhotoListAdapter.photoHolder>() {

    fun updatePhotos(newPhotoList: ArrayList<Photo>?) {
        this.photosList = newPhotoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): photoHolder {
        val itemView : View = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_photos, parent, false)
        return photoHolder(itemView)
    }

    override fun onBindViewHolder(holder: photoHolder?, position: Int) {
        holder?.BindPhotoHolder(photosList!![position])
        holder?.thisView?.setOnClickListener {
            context.startActivity(Intent(context, PhotoViewActivity::class.java)
                    .putExtra("title",photosList!![position].title)
                    .putExtra("url",photosList!![position].url))
        }
    }

    override fun getItemCount(): Int {
        return photosList!!.size
    }

    inner class photoHolder (public var thisView: View) : RecyclerView.ViewHolder(thisView)
    {
        fun BindPhotoHolder(photo: Photo) {
            Picasso.with(context).load(photo.thumbnailUrl)
                    .placeholder(R.mipmap.loading_image_2_icon)
                    .into(thisView.ivThumbnail)
            thisView.tvPhotoTitle.text = photo.title
        }
    }

}