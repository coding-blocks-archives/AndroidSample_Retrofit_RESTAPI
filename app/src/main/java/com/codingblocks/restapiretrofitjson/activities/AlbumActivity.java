package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.api.AlbumAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.interfaces.itemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumActivity extends AppCompatActivity {

    public static final String TAG="post";
    RecyclerView rvAlbum;
    AlbumAdapter albumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        rvAlbum= (RecyclerView) findViewById(R.id.rvAlbum);
        rvAlbum.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter = new AlbumAdapter(this, new ArrayList<Album>());
        rvAlbum.setAdapter(albumAdapter);
        albumAdapter.setOnItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Intent photos = new Intent(AlbumActivity.this,
                        PhotoActivity.class);

                photos.putExtra("userId", itemId);
                startActivity(photos);

            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        final AlbumAPI albumAPI = retrofit.create(AlbumAPI.class);
        albumAPI.getAlbum().enqueue(new Callback<ArrayList<Album>>(){

            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                // Log.d(TAG, "onResponse: ");
               albumAdapter.updateAlbum(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}
