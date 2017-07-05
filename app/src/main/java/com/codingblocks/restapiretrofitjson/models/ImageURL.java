package com.codingblocks.restapiretrofitjson.models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Harshi on 7/5/2017.
 */

public class ImageURL extends AppCompatActivity {
    ImageView ivImageUrl;
    TextView tvImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_thumbnail);
        ivImageUrl=(ImageView)findViewById(R.id.imageView1);
        tvImageTitle=(TextView)findViewById(R.id.tvImageTitle);
        String url=getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
        tvImageTitle.setText(title);
        Picasso.with(this).load(url).into(ivImageUrl);
    }
}
