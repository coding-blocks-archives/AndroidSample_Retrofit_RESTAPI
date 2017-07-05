package com.codingblocks.restapiretrofitjson.adapters;

/**
 * Created by HP on 05-07-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.activities.PhotosActivity;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.Album;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HP on 30-06-2017.
 */

public class AlbumsRecyclerAdapter extends RecyclerView.Adapter<AlbumsRecyclerAdapter.AlbumViewHolder> {
    private ArrayList<Album> albums;
    private Context context;
    private API restAPI;

    public AlbumsRecyclerAdapter(ArrayList<Album> albums, Context context, API restAPI) {
        this.albums = albums;
        this.context = context;
        this.restAPI = restAPI;
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlbumName;
        RecyclerView rvAlbumPhotosList;
        AlbumPhotosRecyclerAdapter adapter;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            this.tvAlbumName = (TextView) itemView.findViewById(R.id.tvAlbumName);
            this.rvAlbumPhotosList = (RecyclerView) itemView.findViewById(R.id.rvAlbumPhotosList);
            this.adapter = new AlbumPhotosRecyclerAdapter(new ArrayList<Photo>(), itemView.getContext());
        }
    }

    public void updateAlbumList(ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.layout_albums_list, parent, false);

        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AlbumViewHolder holder, int position) {
        final Album thisAlbum = albums.get(position);

        holder.tvAlbumName.setText(thisAlbum.getTitle());
        holder.tvAlbumName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotosActivity.class);
                intent.putExtra("albumId", thisAlbum.getId());

                context.startActivity(intent);
            }
        });

        restAPI.getPhotoAPI().getPhotos(thisAlbum.getId()).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                ArrayList<Photo> photos = new ArrayList<Photo>();
                for(int i = 0; i < 7; i++)
                    photos.add(response.body().get(i));

                holder.adapter.updateList(photos);
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });

        holder.rvAlbumPhotosList.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,
                false));
        holder.rvAlbumPhotosList.setAdapter(holder.adapter);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}
