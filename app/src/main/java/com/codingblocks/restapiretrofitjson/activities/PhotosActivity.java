package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotosAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    RecyclerView rvPhotos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        rvPhotos = (RecyclerView)findViewById(R.id.rvPhotoList);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));
        final PhotosAdapter adapter = new PhotosAdapter(new ArrayList<Photo>() ,this) ;
        rvPhotos.setAdapter(adapter);

        adapter.setOpcl(new PhotosAdapter.OnPhotoClickListener() {
            @Override
            public void onClick(String url, String title) {
                Intent i = new Intent(PhotosActivity.this ,LargePhotoActivity.class) ;
                i.putExtra("url" , url) ;
                i.putExtra("title" , title) ;
                startActivity(i);
            }
        });

        int id = getIntent().getIntExtra("id" , 0 ) ;
        API.getInstance().getAlbumsAPI().getPhotoOfAlbum(id).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                adapter.updatePhotoList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });


    }
}
