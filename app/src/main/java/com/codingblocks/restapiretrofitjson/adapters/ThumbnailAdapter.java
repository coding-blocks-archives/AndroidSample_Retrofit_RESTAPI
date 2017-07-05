package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnImageClickListener;
import com.codingblocks.restapiretrofitjson.models.Thumbnail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Harshi on 7/5/2017.
 */

public class ThumbnailAdapter extends RecyclerView.Adapter<ThumbnailAdapter.ThumbnailViewHolder> {

    Context context;
    ArrayList<Thumbnail> thumbnailArrayList;

    private OnImageClickListener oicl;
    public void setOnImageClickListener(OnImageClickListener oicl){
        this.oicl=oicl;
    }

    public ThumbnailAdapter(Context context, ArrayList<Thumbnail> thumbnailArrayList) {
        this.context = context;
        this.thumbnailArrayList = thumbnailArrayList;
    }

    public void updateThumbnail(ArrayList<Thumbnail> newThumbnailList){
        this.thumbnailArrayList=newThumbnailList;
        notifyDataSetChanged();
    }

    @Override
    public ThumbnailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_thumbnail,parent,false);
        return new ThumbnailViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ThumbnailViewHolder holder, int position) {
        final Thumbnail thisThumbnail=thumbnailArrayList.get(position);
        holder.tvThumbnail.setText(thisThumbnail.getTitle());
        Picasso.with(context).load(thisThumbnail.getThumbnailUrl()).into(holder.ivThumbnail);
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl.OnImageClick(thisThumbnail.getUrl(),thisThumbnail.getTitle());
                }
            }
        });

    }


    @Override
    public int getItemCount() {

        return thumbnailArrayList.size();
    }

    class ThumbnailViewHolder extends RecyclerView.ViewHolder{
        TextView tvThumbnail;
        ImageView ivThumbnail;
        View thisView;
        public ThumbnailViewHolder(View itemView){
            super(itemView);
            tvThumbnail=(TextView)itemView.findViewById(R.id.tvThumbnail);
            ivThumbnail=(ImageView)itemView.findViewById(R.id.imageView1);
            thisView=itemView;
        }

    }
}
