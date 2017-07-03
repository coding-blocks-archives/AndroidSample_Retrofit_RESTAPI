package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class LargePhotoActivity extends AppCompatActivity {

    ImageView ivLargePhoto ;
    TextView tvTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_photo);
        ivLargePhoto = (ImageView)findViewById(R.id.ivPhoto) ;
        tvTitle = (TextView)findViewById(R.id.tvPhotoLTitle) ;
        String title = getIntent().getStringExtra("title") ;
        String url = getIntent().getStringExtra("url") ;
        Picasso.with(this).load(url).into(ivLargePhoto);
        tvTitle.setText(title);
    }
}
