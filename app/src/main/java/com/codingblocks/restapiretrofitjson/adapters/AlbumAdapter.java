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

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ravneet on 2/7/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private Context context;
    private ArrayList<Album> albumlist;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AlbumAdapter(Context context,ArrayList<Album> albumlist){
        this.albumlist = albumlist;
        this.context = context;
    }

    public void updateAlbum(ArrayList<Album> albumlist){
        this.albumlist = albumlist;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_album,parent,false);
        return new AlbumViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {

        final Album thisalbum = albumlist.get(position);

        holder.albumTitle.setText(thisalbum.getTitle());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(thisalbum.getId(),view);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumlist.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView albumTitle;
        View thisview;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            thisview = itemView;
            albumTitle = (TextView) itemView.findViewById(R.id.tv_album_title);

        }
    }
}
