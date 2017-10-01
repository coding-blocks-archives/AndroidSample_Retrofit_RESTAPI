package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class AlbumPhotosActivity extends AppCompatActivity {
    TextView tvPhoto;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_photos);
        tvPhoto= (TextView) findViewById(R.id.tvPhoto);
        imageView= (ImageView) findViewById(R.id.imageView);
        String s = getIntent().getStringExtra("title");
        String u = getIntent().getStringExtra("url");
        tvPhoto.setText(s);
        Picasso.with(this).load(u).into(imageView);

    }
}
