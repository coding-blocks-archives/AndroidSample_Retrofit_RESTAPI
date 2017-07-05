package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 05/07/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {
    private Context context;
    private ArrayList<Album> albums;
    private OnItemClickListener onItemClickListener;

    public AlbumsAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    public void updateAlbums(ArrayList<Album> newAlbumList) {
        this.albums = newAlbumList;
        notifyDataSetChanged();
    }

    @Override
    public AlbumsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView  = li.inflate(R.layout.list_item_albums,parent,false);
        return new AlbumsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumsViewHolder holder, int position) {
        final Album thisAlbum = albums.get(position);
        holder.tvAlbums.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisAlbum.getId(), v);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumsViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlbums;
        View thisView;
        public AlbumsViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvAlbums = (TextView) itemView.findViewById(R.id.tv_Albums);

        }
    }
}
