package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.adapters.UserAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {
    final String TAG = "AlbumAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvAlbumList);
        final AlbumAdapter albumAdapter = new AlbumAdapter(this, new ArrayList<Album>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(albumAdapter);

        albumAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent albumIntent = new Intent(AlbumsActivity.this, PhotosListActivity.class);
                albumIntent.putExtra("albumId", itemId);
                startActivity(albumIntent);
            }
        });

        API.getInstance().getAlbumsAPI().getAllAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                Log.d(TAG, "onResponse: ");
                albumAdapter.updateAdapter(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

    }
}
