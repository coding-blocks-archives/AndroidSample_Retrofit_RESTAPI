package com.aarushi.restapiretrofitjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageURL extends AppCompatActivity {
    ImageView ivImageUrl;
    TextView tvImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_url);
        ivImageUrl=(ImageView)findViewById(R.id.ivImageUrl);
        tvImageTitle=(TextView)findViewById(R.id.tvImageTitle);
        String url=getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
        tvImageTitle.setText(title);
        Picasso.with(this).load(url).into(ivImageUrl);
    }
}
