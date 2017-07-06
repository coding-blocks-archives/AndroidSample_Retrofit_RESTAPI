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
import com.codingblocks.restapiretrofitjson.interfaces.ClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ashpreet on 06-07-2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    public static final String TAG = "PHADPTR";
    private Context context;
    private ArrayList<Photo> photos;
    private ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
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
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_photo, parent, false);

        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

        final Photo thisPhoto = photos.get(position);
        String url=thisPhoto.getThumbnailUrl();
        Picasso.with(context).load(url).into(holder.tvPhoto);
        holder.tvPhotoTitle.setText(thisPhoto.getTitle());

        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.Click(thisPhoto.getTitle(),thisPhoto.getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+photos.size());
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvPhotoTitle;
        ImageView tvPhoto;
        View thisView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            tvPhotoTitle = (TextView) itemView.findViewById(R.id.tvPhotoTitle);
            tvPhoto= (ImageView) itemView.findViewById(R.id.tvPhoto);
        }
    }
}
