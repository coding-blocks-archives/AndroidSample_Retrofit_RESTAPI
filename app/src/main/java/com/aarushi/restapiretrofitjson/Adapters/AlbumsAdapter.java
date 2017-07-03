package com.aarushi.restapiretrofitjson.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aarushi.restapiretrofitjson.AlbumThumbnail;
import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.Album;
import com.aarushi.restapiretrofitjson.Models.Post;
import com.aarushi.restapiretrofitjson.R;

import java.util.ArrayList;

/**
 * Created by hp on 7/1/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>{
    Context context;
    ArrayList<Album> albumArrayList;
    OnItemClickListener oicl;
    public void setOnItemClickListener(OnItemClickListener oicl){
        this.oicl=oicl;
    }

    public AlbumsAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    public void updateAlbums(ArrayList<Album> newAlbumList){
        this.albumArrayList=newAlbumList;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_album,parent,false);
        return new AlbumViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(AlbumViewHolder holder, final int position) {
        final Album thisAlbum=albumArrayList.get(position);
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl.OnItemClick(position+1);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlbumTitle;
        View thisView;
        public AlbumViewHolder(View itemView){
            super(itemView);
            tvAlbumTitle=(TextView)itemView.findViewById(R.id.tvAlbumTitle);
            thisView=itemView;
        }

    }

}
