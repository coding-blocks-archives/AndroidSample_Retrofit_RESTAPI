package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.PhotoAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    RecyclerView rvPhotos;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        rvPhotos = (RecyclerView) findViewById(R.id.rv_photo);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));

        photoAdapter = new PhotoAdapter(this,new ArrayList<Photo>());
        rvPhotos.setAdapter(photoAdapter);

        photoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent fullImageActIntent=new Intent(PhotoActivity.this,LargeImageActivity.class);
                fullImageActIntent.putExtra("photoURL",photoAdapter.getPhotos().get(itemId-1).getUrl());
                fullImageActIntent.putExtra("photoTitle",photoAdapter.getPhotos().get(itemId-1).getTitle());
                startActivity(fullImageActIntent);
            }
        });

        PhotoAPI photoAPI = API.getInstance().getPhotoAPI();
        Callback<ArrayList<Photo>> photocallback = new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photoAdapter.updatephotolist(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        };

        int albumIdReceived = getIntent().getIntExtra("albumId", -1);
        photoAPI.getPhotos().enqueue(photocallback);
    }
}
