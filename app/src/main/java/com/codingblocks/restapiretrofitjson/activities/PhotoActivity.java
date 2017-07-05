package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.PhotoAPI;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    RecyclerView rvPhotoListView;
    PhotoAdapter photoAdapter;
    public static final String TAG="PA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        rvPhotoListView= (RecyclerView) findViewById(R.id.rvPhotoListView);
        rvPhotoListView.setLayoutManager(new LinearLayoutManager(this));
        photoAdapter=new PhotoAdapter(new ArrayList<Photo>(),this);
        rvPhotoListView.setAdapter(photoAdapter);
        photoAdapter.setOnPhotoClickListener(new PhotoAdapter.OnPhotoClickListener() {
            @Override
            public void onItemClick(String url, String title) {
                Intent i=new Intent(PhotoActivity.this,ImageActivity.class);
                i.putExtra("image",url);
                i.putExtra("title",title);
                startActivity(i);
            }
        });

        PhotoAPI photoAPI= API.getInstance().getPhotoAPI();
        int photoIdRecieved=getIntent().getIntExtra("id",0);
        photoAPI.getPhotoById(photoIdRecieved).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photoAdapter.updatePhoto(response.body());
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {
            }
        });


    }
}

