package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

/**
 * Created by Suraj on 6/30/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private ArrayList<Album> albumsList;
    private final Context context;
    private OnButtonClickListener onButtonClickListener;
    public AlbumAdapter(ArrayList<Album> albumsList, Context context) {
        this.albumsList = albumsList;
        this.context = context;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    public void updateList(ArrayList<Album> albumsList){
        this.albumsList = albumsList;
        notifyDataSetChanged();
    }
    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(android.R.layout.simple_list_item_1,parent,false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        final Album album = albumsList.get(position);
        holder.tvAlbum.setText(album.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onButtonClickListener!=null){
                    onButtonClickListener.onButtonClicked(album.getId(),-1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        final TextView tvAlbum;
        final View rootView;
        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbum = (TextView)itemView.findViewById(android.R.id.text1);
            rootView = itemView;
        }
    }
}
