package com.example.dell.myappl11assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.myappl11assign.R;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.Album;

import java.util.ArrayList;

/**
 * Created by dell on 01-07-2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    public static final String TAG = "AlbumAdapter";
    private Context context;
    private ArrayList<Album> albums;
    private OnItemClickListener onItemClickListerner;

    public void setOnItemClickListerner(OnItemClickListener onItemClickListerner) {
        this.onItemClickListerner = onItemClickListerner;
    }

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    public void updateAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album,parent,false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ***************");
        final Album thisAlbum=albums.get(position);
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListerner!=null){
                    onItemClickListerner.onItemClick(thisAlbum.getId());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
    TextView tvAlbumTitle;
        View thisView;
        public AlbumViewHolder(View itemView) {
            super(itemView);
            thisView=itemView;
            tvAlbumTitle=(TextView)itemView.findViewById(R.id.tvAlbumTitle);
        }
    }
}
