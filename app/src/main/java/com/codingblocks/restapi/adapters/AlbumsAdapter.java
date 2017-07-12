package com.codingblocks.restapi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.models.Album;

import java.util.ArrayList;

/**
 * Created by championswimmer on 12/07/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {

    private ArrayList<Album> albums;

    public AlbumsAdapter(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new AlbumViewHolder(li.inflate(R.layout.list_item_album, parent, false));
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bindView(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlbumTitle;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbumTitle = (TextView) itemView.findViewById(R.id.tvAlbumTitle);
        }

        void bindView(Album album) {
            tvAlbumTitle.setText(album.getTitle());
        }
    }
}
