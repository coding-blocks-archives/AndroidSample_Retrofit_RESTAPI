package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.AlbumAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener2;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoActivity extends AppCompatActivity {

    public static final String TAG="album";
    RecyclerView rvPhoto;
    PhotoAdapter photoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        rvPhoto= (RecyclerView) findViewById(R.id.rvPhoto);
        rvPhoto.setLayoutManager(new LinearLayoutManager(this));
        photoAdapter = new PhotoAdapter(this, new ArrayList<Photo>());
        rvPhoto.setAdapter(photoAdapter);
        photoAdapter.setOnItemClickListener(new OnItemClickListener2() {
            @Override
            public void onItemClick(String Title,String Url) {
                Intent photo = new Intent(PhotoActivity.this,
                        BigPhotoActivity.class);

                photo.putExtra("Title", Title);
                photo.putExtra("Url", Url);
                startActivity(photo);

            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        final AlbumAPI photoAPI = retrofit.create(AlbumAPI.class);
        int userIdR = getIntent().getIntExtra("userId", -1);
        photoAPI.getPhotoById(userIdR ).enqueue(new Callback<ArrayList<Photo>>(){

            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                Log.d(TAG, "onResponse: ");
                photoAdapter.updatePhoto(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });
    }
}
