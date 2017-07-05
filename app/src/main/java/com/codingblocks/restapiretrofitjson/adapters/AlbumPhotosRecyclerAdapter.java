package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.activities.ShowPhotoActivity;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HP on 05-07-2017.
 */

public class AlbumPhotosRecyclerAdapter extends RecyclerView.Adapter<AlbumPhotosRecyclerAdapter.AlbumPhotoViewHolder> {
    ArrayList<Photo> photos;
    Context context;

    public AlbumPhotosRecyclerAdapter(ArrayList<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    static class AlbumPhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAlbumPhoto;

        public AlbumPhotoViewHolder(View itemView) {
            super(itemView);
            this.ivAlbumPhoto = (ImageView) itemView.findViewById(R.id.ivAlbumPhoto);
        }
    }

    public void updateList(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public AlbumPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View itemView = layoutInflater.inflate(R.layout.layout_album_photos_list, parent, false);

        return new AlbumPhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumPhotoViewHolder holder, int position) {
        final Photo thisPhoto = photos.get(position);

        Picasso.with(context)
                .load(thisPhoto.getThumbnailUrl())
                .placeholder(R.drawable.image_loading)
                .error(R.drawable.image_loading_error)
                .into(holder.ivAlbumPhoto);

        holder.ivAlbumPhoto.setOnClickListener(new View.OnClickListener() {
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
