package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.PhotosAPI;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
    PhotoAdapter photoAdapter;
    RecyclerView rvPhotosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        rvPhotosList = (RecyclerView) findViewById(R.id.rvPhotosList);
        rvPhotosList.setLayoutManager(new LinearLayoutManager(this));
        photoAdapter = new PhotoAdapter(this, new ArrayList<Photo>());
        rvPhotosList.setAdapter(photoAdapter);

        PhotosAPI photosAPI = API.getInstance().getPhotosAPI();
        Callback<ArrayList<Photo>> postCallback = new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photoAdapter.updatePhotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        };
        int useridreceived = getIntent().getIntExtra("id", -1);
        if (useridreceived != -1) {
            photosAPI.getPhotosById(useridreceived).enqueue(postCallback);
        } else {
            photosAPI.getPhotos().enqueue(postCallback);
        }

    }
}
