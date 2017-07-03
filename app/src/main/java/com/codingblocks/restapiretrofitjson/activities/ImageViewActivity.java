package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class ImageViewActivity extends AppCompatActivity {

    ImageView ivFullImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ivFullImage = (ImageView) findViewById(R.id.ivFullImage);
        String UrlReceived = getIntent().getStringExtra("imageURL");
        Picasso.with(this).load(UrlReceived).into(ivFullImage);

    }
}
