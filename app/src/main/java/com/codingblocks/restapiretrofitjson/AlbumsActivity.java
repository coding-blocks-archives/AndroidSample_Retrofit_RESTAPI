package com.codingblocks.restapiretrofitjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.codingblocks.restapiretrofitjson.adapters.AlbumAdapter;
import com.codingblocks.restapiretrofitjson.api.AlbumsAPI;
import com.codingblocks.restapiretrofitjson.interfaces.onItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshi on 7/5/2017.
 */

public class AlbumsActivity extends AppCompatActivity {
    public static final String TAG = "USERS";

    RecyclerView rvAlbumList;
    AlbumAdapter albumAdapter;
    Button btnShowTodos,btnShowPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvAlbumList = (RecyclerView) findViewById(R.id.rvAlbumsList);
        rvAlbumList.setLayoutManager(new LinearLayoutManager(this));
        albumAdapter = new AlbumAdapter(this, new ArrayList<Album>());

        albumAdapter.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void onItemClick(int albumId) {
                Intent i=new Intent(AlbumsActivity.this,AlbumThumbnail.class);
                i.putExtra("albumId",albumId);
                startActivity(i);
            }
        });
        rvAlbumList.setAdapter(albumAdapter);
//
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        final AlbumsAPI albumsAPI = retrofit.create(AlbumsAPI.class);
//          final UsersAPI usersAPI = RestAPI.getInstance().create(UsersAPI.class);


        albumsAPI.getAlbums().enqueue(new Callback<ArrayList<Album>>() {

            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}


