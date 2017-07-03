package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarushi.restapiretrofitjson.API.AlbumsAPI;
import com.aarushi.restapiretrofitjson.Adapters.AlbumsAdapter;
import com.aarushi.restapiretrofitjson.Adapters.ThumbnailAdapter;
import com.aarushi.restapiretrofitjson.Interface.OnImageClickListener;
import com.aarushi.restapiretrofitjson.Models.Album;
import com.aarushi.restapiretrofitjson.Models.Thumbnail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumThumbnail extends AppCompatActivity {
    RecyclerView rvThumbnailList;
    ThumbnailAdapter thumbnailAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_thumbnail);

        rvThumbnailList=(RecyclerView)findViewById(R.id.rvThumbnailList);
        rvThumbnailList.setLayoutManager(new LinearLayoutManager(this));
        thumbnailAdapter=new ThumbnailAdapter(this,new ArrayList<Thumbnail>());
        thumbnailAdapter.setOnImageClickListener(new OnImageClickListener() {
            @Override
            public void OnImageClick(String url,String title) {
                Intent i=new Intent(AlbumThumbnail.this,ImageURL.class);
                i.putExtra("url",url);
                i.putExtra("title",title);
                startActivity(i);
            }
        });
        rvThumbnailList.setAdapter(thumbnailAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        AlbumsAPI albumsAPI=retrofit.create(AlbumsAPI.class);
        albumsAPI.getThumbnail(getIntent().getIntExtra("albumId",0)).enqueue(new Callback<ArrayList<Thumbnail>>() {
            @Override
            public void onResponse(Call<ArrayList<Thumbnail>> call, Response<ArrayList<Thumbnail>> response) {
                thumbnailAdapter.updateThumbnail(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<Thumbnail>> call, Throwable t) {

            }
        });

    }
}
