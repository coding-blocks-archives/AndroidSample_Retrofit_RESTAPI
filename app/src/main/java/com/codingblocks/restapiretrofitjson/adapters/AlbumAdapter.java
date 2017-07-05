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
 * Created by User on 06-07-2017.
 */
public class AlbumAdapter
        extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{
    private Context context;
    private ArrayList<Album> albums;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }
    public void updateAlbums(ArrayList<Album> newalbumlist){
        this.albums = newalbumlist;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_album, parent, false);
        return new AlbumViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        final Album thisalbum = albums.get(position);
        holder.albumtitle.setText(thisalbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisalbum.getId(), view);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView albumtitle;
        View thisView;
        public AlbumViewHolder(View itemview){
            super(itemview);
            thisView = itemview;
            albumtitle = (TextView) itemview.findViewById(R.id.albumtitle);
        }

    }
}

