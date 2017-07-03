package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class BigPhotoActivity extends AppCompatActivity {
    ImageView ivBigPhoto;
    TextView tvBigPhoyoTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_photo);
        ivBigPhoto =(ImageView)findViewById(R.id.ivBigPhoto);
        tvBigPhoyoTitle =(TextView)findViewById(R.id.tvBigPhoyoTitle);

        String userUrlT = getIntent().getStringExtra("Title");
        String userUrlR = getIntent().getStringExtra("Url");

        Picasso.with(this).load(userUrlR).into(ivBigPhoto);
        tvBigPhoyoTitle.setText(userUrlT);
    }
}