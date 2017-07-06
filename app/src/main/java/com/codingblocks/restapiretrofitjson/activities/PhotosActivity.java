package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotosAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    RecyclerView rvPhotos;
    PhotosAdapter photosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        rvPhotos = (RecyclerView) findViewById(R.id.rv_Photos);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));
        photosAdapter = new PhotosAdapter(this,new ArrayList<Photo>());
        rvPhotos.setAdapter(photosAdapter);
        photosAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                startActivity((new Intent(PhotosActivity.this,PicActivity.class)).putExtra("photoId",itemId));

            }
        });
                API.getInstance().getPhotosApi().getPhotoByAlbumId(getIntent().getIntExtra("albumId", -1)).enqueue(new Callback<ArrayList<Photo>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                        photosAdapter.updatePhotos(response.body());

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

                    }
                });

    }
}
