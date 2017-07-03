package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.AlbumAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;
import static android.R.attr.logo;

/**
 * Created by yash on 2/7/17.
 */

public class AlbumsActivity extends AppCompatActivity {

    public static final String TAG ="AlbumActivity";
    RecyclerView rvAlbumList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        rvAlbumList = (RecyclerView) findViewById(R.id.rvAlbumsList);
        rvAlbumList.setLayoutManager(new LinearLayoutManager(this));

        final AlbumAdapter albumAdapter = new AlbumAdapter(this,new ArrayList<Album>());
        rvAlbumList.setAdapter(albumAdapter);

        albumAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int itemId, View view) {
                Intent i = new Intent(AlbumsActivity.this,PhotosListActivity.class);
                i.putExtra("id",itemId);
                startActivity(i);

            }
        });


        AlbumAPI albumAPI = API.getInstance().getAlbumAPI();
         Callback<ArrayList<Album>> albumCallback = new Callback<ArrayList<Album>>() {
         @Override
         public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
             Log.d(TAG, "onResponse: "+response.body().size());
             albumAdapter.updateAlbums(response.body());
         }

         @Override
         public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

         }
     };

    albumAPI.getAlbums().enqueue(albumCallback);

    }

}
