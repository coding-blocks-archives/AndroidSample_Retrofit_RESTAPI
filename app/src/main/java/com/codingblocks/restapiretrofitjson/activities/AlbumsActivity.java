package com.codingblocks.restapiretrofitjson.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumsRecyclerAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {
    RecyclerView rvAlbumsList;

    AlbumsRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAlbum));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAlbum)));

        rvAlbumsList = (RecyclerView) findViewById(R.id.rvAlbumList);

        API restAPI = API.getInstance();

        adapter = new AlbumsRecyclerAdapter(new ArrayList<Album>(), this, restAPI);

        rvAlbumsList.setLayoutManager(new LinearLayoutManager(this));
        rvAlbumsList.setAdapter(adapter);

        int userId = getIntent().getIntExtra("userId", 0);

        Callback callback = new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                adapter.updateAlbumList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        };

        if(userId == 0)
            restAPI.getAlbumAPI().getAlbums(null).enqueue(callback);
        else
            restAPI.getAlbumAPI().getAlbums(userId).enqueue(callback);
    }
}
