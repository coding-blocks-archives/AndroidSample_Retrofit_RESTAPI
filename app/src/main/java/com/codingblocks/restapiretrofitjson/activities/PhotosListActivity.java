package com.codingblocks.restapiretrofitjson.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.adapters.PhotoAdapter;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.api.AlbumAPI;
import com.codingblocks.restapiretrofitjson.api.PhotosAPI;
import com.codingblocks.restapiretrofitjson.interfaces.OnItemClickListener;
import com.codingblocks.restapiretrofitjson.models.Photos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yash on 2/7/17.
 */

public class PhotosListActivity extends AppCompatActivity{

    RecyclerView rvPhotosList;
    PhotoAdapter photoAdapter;
    public static final String TAG="PhotosActivity";

    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos_list);
        rvPhotosList = (RecyclerView) findViewById(R.id.rvPhotosList);
        rvPhotosList.setLayoutManager(new LinearLayoutManager(this));


        photoAdapter = new PhotoAdapter(this, new ArrayList<Photos>());
        rvPhotosList.setAdapter(photoAdapter);

        photoAdapter.setOnPhotoClicked(new PhotoAdapter.OnPhotoClicked() {
            @Override
            public void ClickOnPhoto(String photoUrl) {
                Intent i = new Intent(PhotosListActivity.this,ImageViewActivity.class);
                i.putExtra("imageURL",photoUrl);
                startActivity(i);
            }
        });

        AlbumAPI.PhotosAPI  photosAPI = (AlbumAPI.PhotosAPI) API.getInstance().getPhotosAPI();
        Callback<ArrayList<Photos>> photoCallBack = new Callback<ArrayList<Photos>>() {
            @Override
            public void onResponse(Call<ArrayList<Photos>> call, Response<ArrayList<Photos>> response) {
                Log.d(TAG, "onResponse: "+response.body().size());
                photoAdapter.updatePhotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photos>> call, Throwable t) {

            }
        };
        int idReceived = getIntent().getIntExtra("id",0);
        Log.d(TAG, "onCreate: idReceivedFromIntent"+idReceived);
        photosAPI.getPhotosOfAlbum(idReceived).enqueue(photoCallBack);


    }
}
