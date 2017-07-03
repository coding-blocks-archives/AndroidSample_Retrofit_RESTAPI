package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.AlbumsAPI;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AlbumActivity extends AppCompatActivity {

    RecyclerView rvAlbumList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        rvAlbumList = (RecyclerView)findViewById(R.id.rvAlbumList);
        rvAlbumList.setLayoutManager(new LinearLayoutManager(this));
        final AlbumAdapter adapter = new AlbumAdapter(new ArrayList<Album>() , this) ;
        rvAlbumList.setAdapter(adapter);



         API.getInstance().getAlbumsAPI().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                      adapter.updateAlbumList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        }); ;


    }
}
