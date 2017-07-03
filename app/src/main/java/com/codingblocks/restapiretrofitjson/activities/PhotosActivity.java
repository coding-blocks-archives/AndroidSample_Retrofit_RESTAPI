package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotosAdapter;
import com.codingblocks.restapiretrofitjson.apis.PhotoApi;
import com.codingblocks.restapiretrofitjson.apis.RestApi;
import com.codingblocks.restapiretrofitjson.interfaces.OnPhotoClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    private static final String TAG = "PhotosActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv_photo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final PhotosAdapter photosAdapter = new PhotosAdapter(new ArrayList<Photo>(),this);
        recyclerView.setAdapter(photosAdapter);

        PhotoApi photoApi = RestApi.getInstance().getPhotoApi();
        photoApi.getPhotosByAlbumId(getIntent().getIntExtra("albumId",-1)).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Photo>> call, @NonNull Response<ArrayList<Photo>> response) {
                photosAdapter.updateList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Photo>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });

        photosAdapter.setOnPhotoClickListener(new OnPhotoClickListener() {
            @Override
            public void onPhotoClicked(String url, String title) {
                Intent i = new Intent(PhotosActivity.this,PhotoViewActivity.class);
                i.putExtra("url",url);
                i.putExtra("title",title);
                startActivity(i);
            }
        });

    }
}
