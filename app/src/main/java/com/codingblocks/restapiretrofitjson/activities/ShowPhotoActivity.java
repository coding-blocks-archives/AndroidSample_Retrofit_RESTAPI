package com.codingblocks.restapiretrofitjson.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.Photo;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPhotoActivity extends AppCompatActivity {
    TextView tvPhotoTitle;
    ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photo);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().setStatusBarColor(getResources().getColor(android.R.color.black));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));

        tvPhotoTitle = (TextView) findViewById(R.id.tvPhotoTitle);
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);

        int id = getIntent().getIntExtra("photoId", 0);

        if(id != 0)
            API.getInstance().getPhotoAPI().getPhoto(id).enqueue(new Callback<Photo>() {
                @Override
                public void onResponse(Call<Photo> call, Response<Photo> response) {
                    Picasso.with(ShowPhotoActivity.this).load(response.body().getUrl())
                            .placeholder(R.drawable.image_loading)
                            .error(R.drawable.image_loading_error)
                            .into(ivPhoto);
                    tvPhotoTitle.setText(response.body().getTitle());
                }

                @Override
                public void onFailure(Call<Photo> call, Throwable t) {

                }
            });
    }
}
