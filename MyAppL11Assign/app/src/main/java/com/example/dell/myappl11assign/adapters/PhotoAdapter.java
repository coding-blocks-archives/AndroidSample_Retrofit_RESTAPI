package com.example.dell.myappl11assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.myappl11assign.R;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dell on 01-07-2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    public static final String TAG = "PhotoAdapter";
    private Context context;
    private ArrayList<Photo> photos;
    private OnItemClickListener onItemClickListener;

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PhotoAdapter(Context context, ArrayList<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }

    public void updatePhotos(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photo, parent, false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: **************");
        final Photo thisPhoto = photos.get(position);
        String imageURL=thisPhoto.getThumbnailUrl();
        Log.d(TAG, "onBindViewHolder: **************  "+thisPhoto.getUrl());
        Log.d(TAG, "onBindViewHolder: **************  "+thisPhoto.getThumbnailUrl());
        if(imageURL!=null){
            Picasso.with(context).load(imageURL).error(R.drawable.ic_missing).into(holder.ivPhotoThumbnail);
        }
        //Picasso.with(context).load(thisPhoto.getThumbnaulUrl()).into(holder.ivPhotoThumbnail);
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());

        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(thisPhoto.getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhotoThumbnail;
        TextView tvPhotoTitle;
        View thisView;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            ivPhotoThumbnail = (ImageView) itemView.findViewById(R.id.ivPhotoThumbnail);
            tvPhotoTitle = (TextView) itemView.findViewById(R.id.tvPhotoTitle);
        }
    }
}
