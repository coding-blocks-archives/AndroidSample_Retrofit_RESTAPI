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

import static com.codingblocks.restapiretrofitjson.R.id.photothumbnail;

/**
 * Created by User on 06-07-2017.
 */

public class PhotoAdapter
        extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{
    private Context context;
    private ArrayList<Photo> photos;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PhotoAdapter(Context context, ArrayList<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }
    public void updatePhotos(ArrayList<Photo> newphotolist){
        this.photos = newphotolist;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_photo, parent, false);
        return new PhotoViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        final Photo thisphoto = photos.get(position);
        holder.phototitle.setText(thisphoto.getTitle());
        Picasso.with(context).load(thisphoto.getThumbnailUrl()).into(holder.photothumbnail);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisphoto.getId(), view);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{
        TextView phototitle;
        ImageView photothumbnail;
        View thisView;
        public PhotoViewHolder(View itemview){
            super(itemview);
            thisView = itemview;
            phototitle = (TextView) itemview.findViewById(R.id.phototitle);
            photothumbnail = (ImageView) itemview.findViewById(R.id.photothumbnail);
        }

    }
}

