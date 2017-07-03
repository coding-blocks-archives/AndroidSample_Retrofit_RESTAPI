package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.interfaces.itemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

/**
 * Created by HP on 03-07-2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{

    public static final String TAG = "post";

    private Context context;
    private ArrayList<Album> album;
    private itemClickListener onItemClickListener;

    public void setOnItemClickListener(itemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AlbumAdapter(Context context, ArrayList<Album> album) {
        Log.d(TAG, "PostAdapter: ");
        this.context = context;
        this.album = album;
    }

    public void updateAlbum(ArrayList<Album> newAlbumList) {
        Log.d(TAG, "updatePost: ");
        this.album = newAlbumList;
        notifyDataSetChanged();
    }

    @Override
    public AlbumAdapter.AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album, parent, false);
        return new AlbumAdapter.AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumAdapter.AlbumViewHolder holder, int position) {
        final Album thisAlbum = album.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(thisAlbum.getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return album.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView tvAlbumTitle;
        View thisView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            tvAlbumTitle = (TextView) itemView.findViewById(R.id.tvAlbumTitle);
        }
    }
}

