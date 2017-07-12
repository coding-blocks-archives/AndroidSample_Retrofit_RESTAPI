package com.codingblocks.restapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapi.R;
import com.codingblocks.restapi.adapters.AlbumsAdapter;
import com.codingblocks.restapi.api.Client;
import com.codingblocks.restapi.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {
    RecyclerView rvAlbumsList;
    AlbumsAdapter albumsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        rvAlbumsList = (RecyclerView) findViewById(R.id.rvAlbumsList);
        albumsAdapter = new AlbumsAdapter(new ArrayList<Album>());

        rvAlbumsList.setLayoutManager(new LinearLayoutManager(this));
        rvAlbumsList.setAdapter(albumsAdapter);

        Client.getInstance().getApi().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumsAdapter.setAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}
