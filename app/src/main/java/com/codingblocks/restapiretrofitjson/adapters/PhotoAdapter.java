package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Photos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yash on 3/7/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.photosViewHolder>{

    Context context;
    ArrayList<Photos> photosArrayList;
    public static final String TAG="PhotosAdapter";


    public interface OnPhotoClicked{
        public void ClickOnPhoto(String photoUrl);
    }

    private OnPhotoClicked onPhotoClicked;

    public PhotoAdapter(Context context, ArrayList<Photos> photosArrayList) {
        this.context = context;
        this.photosArrayList = photosArrayList;
    }

    public void setOnPhotoClicked(OnPhotoClicked onPhotoClicked) {
        this.onPhotoClicked = onPhotoClicked;
    }

    public void updatePhotos(ArrayList<Photos> photosList) {
        this.photosArrayList = photosList;
        notifyDataSetChanged();
    }

    @Override
    public photosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photos_list,parent,false);
        return new photosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(photosViewHolder holder, int position) {

        final Photos thisPhoto = photosArrayList.get(position);
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());
        Picasso.with(context).load(thisPhoto.getThumbnailUrl()).into(holder.ivThumbnail);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(onPhotoClicked!=null)
               {
                   onPhotoClicked.ClickOnPhoto(thisPhoto.getUrl());
               }
            }
        });

    }

    @Override
    public int getItemCount() {
        return photosArrayList.size();
    }

    public class photosViewHolder extends RecyclerView.ViewHolder{

        ImageView ivThumbnail;
        TextView tvPhotoTitle;
        View rootView;
        public photosViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            tvPhotoTitle = (TextView) itemView.findViewById(R.id.tvPhotoTitle);
            rootView = itemView;
        }
    }

}
