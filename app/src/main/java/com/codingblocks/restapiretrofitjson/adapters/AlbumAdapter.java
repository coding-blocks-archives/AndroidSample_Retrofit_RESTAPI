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
 * Created by namankhanna on 7/5/17.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    ArrayList<Album> albumArrayList;

    Context context;

    public static final String TAG="AA";

    public AlbumAdapter(ArrayList<Album> albumArrayList, Context context) {
        this.albumArrayList = albumArrayList;
        this.context = context;
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void updatealbum(ArrayList<Album> albumArrayList)
    {
        this.albumArrayList=albumArrayList;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_album,parent,false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {

        final Album thisAlbum=albumArrayList.get(position);
        holder.tvAlbumTitle.setText(thisAlbum.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null)
                    onItemClickListener.onItemClick(thisAlbum.getId(),view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }


    class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView tvAlbumTitle;
        View rootView;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbumTitle= (TextView) itemView.findViewById(R.id.tvAlbumTitle);
            rootView = itemView;

        }
    }
}
