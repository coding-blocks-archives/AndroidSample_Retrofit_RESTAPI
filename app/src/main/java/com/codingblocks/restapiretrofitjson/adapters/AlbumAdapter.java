package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener2;
import com.codingblocks.restapiretrofitjson.models.Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.codingblocks.restapiretrofitjson.R.id.ivAlbum;

/**
 * Created by kunalrustagi on 7/5/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Context context;
    public ArrayList<Album> albums;
    private OnItemClickListener2 onItemClickListener2;

    public void setOnItemClickListener2(OnItemClickListener2 onItemClickListener2) {
        this.onItemClickListener2 = onItemClickListener2;
    }

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }
    public void updateAlbums(ArrayList<Album> albums)
    {
        this.albums=albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album , parent , false);

        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        final Album thisalbum = albums.get(position);
        holder.tvAlbumTitle.setText(albums.get(position).getTitle());
        String url = albums.get(position).getThumbnailUrl();
        Picasso.with(context).load(url).into(holder.ivAlbums);
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener2 !=null)
                {
                    onItemClickListener2.onItemClick(thisalbum.getTitle() , thisalbum.getUrl());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder
    { TextView tvAlbumTitle;
        ImageView ivAlbums;
        View thisview;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            thisview=itemView;
            tvAlbumTitle = (TextView) itemView.findViewById(R.id.tvAlbumTitle);
            ivAlbums = (ImageView) itemView.findViewById(ivAlbum);
        }
    }

}
