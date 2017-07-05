package com.example.dell.myappl11assign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.myappl11assign.adapters.AlbumAdapter;
import com.example.dell.myappl11assign.api.AlbumsAPI;
import com.example.dell.myappl11assign.interfaces.OnItemClickListener;
import com.example.dell.myappl11assign.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumsActivity extends AppCompatActivity {
    public static final String TAG="AlbumsActivity";
    RecyclerView rvAlbumsList;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        rvAlbumsList= (RecyclerView) findViewById(R.id.rvAlbumsList);
        rvAlbumsList.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter=new AlbumAdapter(this,new ArrayList<Album>());
        rvAlbumsList.setAdapter(albumAdapter);
        albumAdapter.setOnItemClickListerner(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                Intent photoActIntent=new Intent(AlbumsActivity.this,PhotosActivity.class);
                photoActIntent.putExtra("albumId",itemId);
                startActivity(photoActIntent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        AlbumsAPI albumsAPI=retrofit.create(AlbumsAPI.class);
        Callback<ArrayList<Album>>albumCallBack=new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                Log.d(TAG, "onResponse: *****************");
                albumAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        };
        albumsAPI.getAlbums().enqueue(albumCallBack);
    }
}
