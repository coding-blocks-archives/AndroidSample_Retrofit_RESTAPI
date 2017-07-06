package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.PhotosAPI;
import com.codingblocks.restapiretrofitjson.interfaces.ClickListener;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoActivity extends AppCompatActivity {

    public static final String TAG = "PHA";

    RecyclerView rvPhotosList;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        rvPhotosList = (RecyclerView) findViewById(R.id.rvPhotoLists);
        rvPhotosList.setLayoutManager(new LinearLayoutManager(this));
        photoAdapter = new PhotoAdapter(this, new ArrayList<Photo>());
        rvPhotosList.setAdapter(photoAdapter);

        photoAdapter.setOnItemClickListener(new ClickListener() {
            @Override
            public void Click(String title,String ur) {
                Intent i = new Intent(PhotoActivity.this,BigPhoto.class);
                i.putExtra("title",title);
                i.putExtra("url",ur);
                startActivity(i);
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
                Log.d(TAG, "onResponse: ");
                photoAdapter.updatePhotos(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        };

        int photoIdReceived = getIntent().getIntExtra("userId", -1);
        if (photoIdReceived != -1) {
            photosAPI.getPhotosByAlbumId(photoIdReceived).enqueue(photoCallback);
        } else {
            photosAPI.getPhotos().enqueue(photoCallback);
        }
    }
}
