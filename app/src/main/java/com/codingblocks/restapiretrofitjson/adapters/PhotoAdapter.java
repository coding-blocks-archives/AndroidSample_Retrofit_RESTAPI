package com.codingblocks.restapiretrofitjson.adapters;

/**
 * Created by HP on 03-07-2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener2;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    public static final String TAG = "photoAdapter";

    private Context context;
    private ArrayList<Photo> photo;
    private OnItemClickListener2 onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener2 onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PhotoAdapter(Context context, ArrayList<Photo> photo) {
        Log.d(TAG, "PhotoAdapter: ");
        this.context = context;
        this.photo = photo;
    }

    public void updatePhoto(ArrayList<Photo> newPhotoList) {
        Log.d(TAG, "updatePhoto: ");
        this.photo = newPhotoList;
        notifyDataSetChanged();
    }

    @Override
    public PhotoAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photo, parent, false);
        return new PhotoAdapter.PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoAdapter.PhotoViewHolder holder, int position) {
        final Photo thisPhoto = photo.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());
        Picasso.with(context).load(thisPhoto.getThumbnailUrl()).into(holder.ivPhoto);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisPhoto.getTitle(),thisPhoto.getUrl());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return photo.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvPhotoTitle;
        ImageView ivPhoto;
        View thisView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            tvPhotoTitle = (TextView) itemView.findViewById(R.id.tvPhotoTitle);
            ivPhoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
        }
    }
}



