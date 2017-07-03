package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.apis.AlbumApi;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.interfaces.OnButtonClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {

    private static final String TAG = "AlbumActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_Album);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final AlbumAdapter albumAdapter = new AlbumAdapter(new ArrayList<Album>(),this);
        recyclerView.setAdapter(albumAdapter);

        AlbumApi albumApi = RestApi.getInstance().getAlbumApi();
        albumApi.getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Album>> call, @NonNull Response<ArrayList<Album>> response) {
                albumAdapter.updateList(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<Album>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
        albumAdapter.setOnButtonClickListener(new OnButtonClickListener() {
            @Override
            public void onButtonClicked(int Id, int buttonId) {
                Intent i = new Intent(AlbumActivity.this,PhotosActivity.class);
                i.putExtra("albumId",Id);
                startActivity(i);
            }
        });

    }
}
