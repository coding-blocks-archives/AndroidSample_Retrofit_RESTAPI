package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class PhotoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        Picasso.with(this).load(getIntent().getStringExtra("url")).placeholder(R.mipmap.loading_image_2_icon)
                .into((ImageView) findViewById(R.id.ivPhoto));
        ((TextView)findViewById(R.id.tvPhotoViewTitle)).setText(getIntent().getStringExtra("title"));
    }
}
