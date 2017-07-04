package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class LargeImageActivity extends AppCompatActivity {

    ImageView largeimage;
    TextView title_largeimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);

        largeimage = (ImageView) findViewById(R.id.iv_largeimage);
        title_largeimage = (TextView) findViewById(R.id.tv_largeimage_title);

        String imageUrlRecived = getIntent().getStringExtra("photoURL");
        if(imageUrlRecived != null){
            Picasso.with(LargeImageActivity.this).load(imageUrlRecived).error(R.drawable.no_image).into(largeimage);
        }

        String imagetitleRecived = getIntent().getStringExtra("photoTitle");
        if(imagetitleRecived != null){
            title_largeimage.setText(imagetitleRecived);
        }

    }
}
