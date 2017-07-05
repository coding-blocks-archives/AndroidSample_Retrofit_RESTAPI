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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {

    RecyclerView rvAlbumListView;
    AlbumAdapter albumAdapter;
    public static final String TAG="AA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvAlbumListView= (RecyclerView) findViewById(R.id.rvAlbumListView);
        rvAlbumListView.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter=new AlbumAdapter(new ArrayList<Album>(),this);
        rvAlbumListView.setAdapter(albumAdapter);
        albumAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent i=new Intent(AlbumActivity.this,PhotoActivity.class);
                i.putExtra("id",itemId);
                startActivity(i);
            }
        });

       AlbumAPI albumAPI=API.getInstance().getAlbumAPI();
        albumAPI.getAlbum().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumAdapter.updatealbum(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}