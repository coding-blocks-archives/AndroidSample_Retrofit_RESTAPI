package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by namankhanna on 7/5/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    ArrayList<Photo> photoArrayList;
    Context context;

    public static final String TAG="PA";

    public interface OnPhotoClickListener {
        public void onItemClick(String url,String title);
    }

    public void setOnPhotoClickListener(OnPhotoClickListener onPhotoClickListener) {
        this.onPhotoClickListener = onPhotoClickListener;
    }

    private OnPhotoClickListener onPhotoClickListener;

    public PhotoAdapter(ArrayList<Photo> photoArrayList, Context context) {
        this.photoArrayList = photoArrayList;
        this.context = context;
    }



    public void updatePhoto(ArrayList<Photo> photoArrayList)
    {
        this.photoArrayList=photoArrayList;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_photo,parent,false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        final Photo thisPhoto=photoArrayList.get(position);
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());
        Picasso.with(context).load(thisPhoto.getThumbnailUrl()).into(holder.ivPhoto);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onPhotoClickListener!=null)
                    onPhotoClickListener.onItemClick(thisPhoto.getUrl(),thisPhoto.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvPhotoTitle;
        View rootView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            tvPhotoTitle= (TextView) itemView.findViewById(R.id.tvTitle);
            ivPhoto= (ImageView) itemView.findViewById(R.id.ivPhoto);
            rootView = itemView;
        }
    }
}