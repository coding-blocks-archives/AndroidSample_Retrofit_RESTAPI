package com.codingblocks.restapiretrofitjson.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class PhotoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);

        ImageView imageView = (ImageView)findViewById(R.id.iv_photo);
        TextView textView = (TextView)findViewById(R.id.tv_photo);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(imageView);
        textView.setText(getIntent().getStringExtra("title"));
    }
}
