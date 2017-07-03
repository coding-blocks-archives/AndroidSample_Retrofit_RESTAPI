package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.AlbumAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView rvalbum;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvalbum = (RecyclerView)findViewById(R.id.rv_album);
        rvalbum.setLayoutManager(new LinearLayoutManager(this));

        albumAdapter = new AlbumAdapter(this,new ArrayList<Album>());
        rvalbum.setAdapter(albumAdapter);

        albumAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent i = new Intent(AlbumActivity.this,PhotoActivity.class);
                i.putExtra("albumId",itemId);
                startActivity(i);
            }
        });

        AlbumAPI albumAPI = API.getInstance().getAlbumAPI();

        Callback<ArrayList<Album>> albumcallback = new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumAdapter.updateAlbum(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        };

        int albumIdRecived = getIntent().getIntExtra("userId",-1);
        albumAPI.getAlbum().enqueue(albumcallback);
    }
}
