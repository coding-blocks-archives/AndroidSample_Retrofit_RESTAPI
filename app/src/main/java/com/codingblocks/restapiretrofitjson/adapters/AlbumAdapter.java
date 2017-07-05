package com.codingblocks.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.interfaces.onItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

/**
 * Created by Harshi on 7/5/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Context context;
    private ArrayList<Album> albums;
    private onItemClickListener ontitleClickListener;
    private onItemClickListener oicl;


    public void setOnItemClickListener(onItemClickListener oicl) {
        this.ontitleClickListener = (onItemClickListener) oicl;
    }

    public AlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    public void updateAlbums (ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album, parent, false);

        return new AlbumAdapter.AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, final int position) {
//        final Album thisAlbum = albums.get(position);
//        holder.tvtitle.setText(thisAlbum.getTitle());
//        holder.thisView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (ontitleClickListener != null) {
//                    ontitleClickListener.OnItemClicks(thisAlbum.getTitle());
//                }
//            }
//        });
////        holder.thisView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if(oicl!=null){
////                    oicl.OnItemClicks(position+1);
////                }
////            }
////        });
//
//
//    }
        final Album thisAlbum=albums.get(position);
        holder.tvtitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oicl!=null){
                    oicl.onItemClick(position+1);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView tvtitle;
        View thisView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvtitle = (TextView) itemView.findViewById(R.id.tvShowTitle);
        }
    }
}

