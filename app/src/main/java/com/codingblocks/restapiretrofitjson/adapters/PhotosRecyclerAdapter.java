package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.activities.ShowPhotoActivity;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HP on 05-07-2017.
 */

public class PhotosRecyclerAdapter extends RecyclerView.Adapter<PhotosRecyclerAdapter.PhotoViewHolder> {
    ArrayList<Photo> photos;
    Context context;

    public PhotosRecyclerAdapter(ArrayList<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {
        TextView tvPhotoTitle;
        ImageView ivPhotoThumb;
        View itemView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            this.tvPhotoTitle = (TextView) itemView.findViewById(R.id.tvPhotoTitle);
            this.ivPhotoThumb = (ImageView) itemView.findViewById(R.id.ivPhotoThumb);
            this.itemView = itemView;
        }
    }

    public void updatePhotoList(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.layout_photo_list, parent, false);

        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        final Photo thisPhoto = photos.get(position);

        holder.tvPhotoTitle.setText(thisPhoto.getTitle());
        Picasso.with(context).load(thisPhoto.getThumbnailUrl())
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_loading_error)
                .into(holder.ivPhotoThumb);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowPhotoActivity.class);
                intent.putExtra("photoId", thisPhoto.getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
