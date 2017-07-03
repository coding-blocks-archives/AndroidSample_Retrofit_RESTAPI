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
 * Created by anirudh on 03/07/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    ArrayList<Album> albumArrayList ;
    Context context ;

    OnItemClickListener oacl ;

    public void setOnItemClickListener(OnItemClickListener oacl) {
        this.oacl = oacl;
    }

    public void updateAlbumList(ArrayList<Album> albums){
        this.albumArrayList =albums ;
        notifyDataSetChanged();
    }


    public AlbumAdapter(ArrayList<Album> albumArrayList, Context context) {
        this.albumArrayList = albumArrayList;
        this.context = context;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album ,parent ,false) ;

        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AlbumViewHolder holder, final int position) {
        final Album thisAlbum =  albumArrayList.get(position) ;
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oacl !=null)
                oacl.onItemClick(thisAlbum.getId() , holder.thisView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlbumTitle ;
        View thisView ;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbumTitle = (TextView) itemView.findViewById(R.id.tvAlbumTitle);
            thisView = itemView ;
        }
    }
}
