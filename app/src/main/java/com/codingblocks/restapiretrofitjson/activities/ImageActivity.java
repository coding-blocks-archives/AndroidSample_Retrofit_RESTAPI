package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ivPhoto= (ImageView) findViewById(R.id.ivPhoto);
        tvTitle= (TextView) findViewById(R.id.tvTitle);

        Picasso.with(ImageActivity.this).load((getIntent().getStringExtra("image"))).into(ivPhoto);
        tvTitle.setText((getIntent().getStringExtra("title")));


    }
}
