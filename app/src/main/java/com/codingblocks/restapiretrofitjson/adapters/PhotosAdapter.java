package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnPhotoClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder> {

    private ArrayList<Photo> photosList;
    private final Context context;
    private OnPhotoClickListener onPhotoClickListener;
    public PhotosAdapter(ArrayList<Photo> photosList, Context context) {
        this.photosList = photosList;
        this.context = context;
    }

    public void setOnPhotoClickListener(OnPhotoClickListener onPhotoClickListener) {
        this.onPhotoClickListener = onPhotoClickListener;
    }

    public void updateList(ArrayList<Photo> photosList){
        this.photosList = photosList;
        notifyDataSetChanged();
    }
    @Override
    public PhotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_photos,parent,false);
        return new PhotosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosViewHolder holder, int position) {
       final Photo photo = photosList.get(position);
        holder.tvPhotoTitle.setText(photo.getTitle());
        Picasso.with(context).load(photo.getThumbnailUrl()).into(holder.ivThumbnail);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onPhotoClickListener!=null){
                    onPhotoClickListener.onPhotoClicked(photo.getUrl(),photo.getTitle());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    class PhotosViewHolder extends RecyclerView.ViewHolder{
        final TextView tvPhotoTitle;
        final ImageView ivThumbnail;
        final View rootView;
        public PhotosViewHolder(View itemView) {
            super(itemView);
            tvPhotoTitle = itemView.findViewById(R.id.tv_title);
            ivThumbnail = itemView.findViewById(R.id.iv_thumb);
            rootView = itemView;
        }
    }
}
