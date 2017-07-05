package com.example.dell.myappl11assign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.myappl11assign.adapters.PhotoAdapter;
import com.example.dell.myappl11assign.api.PhotosAPI;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotosActivity extends AppCompatActivity {
    public static final String TAG = "PhotosActivity";
    RecyclerView rvPhotoList;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        rvPhotoList = (RecyclerView) findViewById(R.id.rvPhotosList);
        rvPhotoList.setLayoutManager(new LinearLayoutManager(this));
        photoAdapter = new PhotoAdapter(this, new ArrayList<Photo>());
        rvPhotoList.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Intent fullImageActIntent=new Intent(PhotosActivity.this,FullImageActivity.class);
                fullImageActIntent.putExtra("photoURL",photoAdapter.getPhotos().get(itemId-1).getUrl());
                fullImageActIntent.putExtra("photoTitle",photoAdapter.getPhotos().get(itemId-1).getTitle());
                startActivity(fullImageActIntent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        PhotosAPI photosAPI = retrofit.create(PhotosAPI.class);
        Callback<ArrayList<Photo>> photoCallback = new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                Log.d(TAG, "onResponse: *************************");
                photoAdapter.updatePhotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        };
        int albumIdReceived = getIntent().getIntExtra("albumId", -1);
        if (albumIdReceived != -1) {
            photosAPI.getPhotosOfId(albumIdReceived).enqueue(photoCallback);
        } else {
            photosAPI.getPhotos().enqueue(photoCallback);
        }

    }
}
