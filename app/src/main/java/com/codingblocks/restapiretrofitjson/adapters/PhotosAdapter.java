package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Created by anirudh on 03/07/17.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private ArrayList<Photo> photoArrayList ;
    private Context context ;
    private OnPhotoClickListener opcl ;

    public void setOpcl(OnPhotoClickListener opcl) {
        this.opcl = opcl;
    }

    public PhotosAdapter(ArrayList<Photo> photoArrayList, Context context) {
        this.photoArrayList = photoArrayList;
        this.context = context;
    }
    public interface OnPhotoClickListener{
        public void onClick(String url ,String title) ;
    }
    public void updatePhotoList(ArrayList<Photo> photos){
        this.photoArrayList = photos ;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photos ,parent ,false) ;
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        final Photo thisPhoto = photoArrayList.get(position) ;
        Picasso.with(context).load(thisPhoto.getThumbnailUrl()).into(holder.ivThumbnail);
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcl.onClick(thisPhoto.getUrl() ,thisPhoto.getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        ImageView ivThumbnail ;
        TextView tvPhotoTitle ;
        View thisView ;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            ivThumbnail = (ImageView)itemView.findViewById(R.id.ivThumbnail) ;
            tvPhotoTitle =(TextView)itemView.findViewById(R.id.tvPhotoTitle) ;
            thisView = itemView ;
        }
    }
}


