package com.codingblocks.restapiretrofitjson.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotosRecyclerAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView rvPhotosList;

    PhotosRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAlbum));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAlbum)));

        rvPhotosList = (RecyclerView) findViewById(R.id.rvPhotosList);

        API restAPI = API.getInstance();

        adapter = new PhotosRecyclerAdapter(new ArrayList<Photo>(), this);

        rvPhotosList.setLayoutManager(new LinearLayoutManager(this));
        rvPhotosList.setAdapter(adapter);

        int albumId = getIntent().getIntExtra("albumId", 0);

        Callback callback = new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                adapter.updatePhotoList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        };

        if(albumId == 0)
            restAPI.getPhotoAPI().getPhotos(null).enqueue(callback);
        else
            restAPI.getPhotoAPI().getPhotos(albumId).enqueue(callback);
    }
}
