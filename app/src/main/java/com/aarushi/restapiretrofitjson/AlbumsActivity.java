package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aarushi.restapiretrofitjson.API.AlbumsAPI;
import com.aarushi.restapiretrofitjson.Adapters.AlbumsAdapter;
import com.aarushi.restapiretrofitjson.Adapters.PostsAdapter;
import com.aarushi.restapiretrofitjson.Interface.OnItemClickListener;
import com.aarushi.restapiretrofitjson.Models.Album;
import com.aarushi.restapiretrofitjson.Models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumsActivity extends AppCompatActivity {
    RecyclerView rvAlbumsList;

    AlbumsAdapter albumsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        rvAlbumsList=(RecyclerView)findViewById(R.id.rvAlbumsList);
        rvAlbumsList.setLayoutManager(new LinearLayoutManager(this));
        albumsAdapter=new AlbumsAdapter(this,new ArrayList<Album>());
        albumsAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int albumId) {
                Intent i=new Intent(AlbumsActivity.this,AlbumThumbnail.class);
                i.putExtra("albumId",albumId);
                startActivity(i);
            }
        });
        rvAlbumsList.setAdapter(albumsAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        AlbumsAPI albumsAPI=retrofit.create(AlbumsAPI.class);
        albumsAPI.getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumsAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });

    }
}
