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
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ravneet on 2/7/17.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private Context context;
    private ArrayList<Photo> photolist;
    private OnItemClickListener onItemClickListener;

    public ArrayList<Photo> getPhotos(){
        return photolist;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PhotoAdapter(Context context,ArrayList<Photo> photolist){
        this.photolist = photolist;
        this.context = context;
    }

    public void updatephotolist(ArrayList<Photo> photolist){
        this.photolist = photolist;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_photo,parent,false);

        return new PhotoViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

        final Photo thisphoto = photolist.get(position);

        String imageUrl = thisphoto.getThumbnailUrl();

        if(imageUrl != null){
            Picasso.with(context).load(imageUrl).error(R.drawable.no_image).into(holder.ivPhotoThumb);
        }

        holder.title.setText(thisphoto.getTitle());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(thisphoto.getId(),view);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return photolist.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPhotoThumb;
        TextView title;
        View thisview;

        public PhotoViewHolder(View itemView) {
            super(itemView);

            ivPhotoThumb = (ImageView) itemView.findViewById(R.id.iv_photo);
            title = (TextView) itemView.findViewById(R.id.tv_photo_title);
            thisview = itemView;
        }
    }
}
