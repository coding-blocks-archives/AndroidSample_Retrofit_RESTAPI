package com.codingblocks.restapiretrofitjson.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.squareup.picasso.Picasso;

public class BigPhoto extends AppCompatActivity {

    ImageView bigphoto;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_photo);
        bigphoto=(ImageView)findViewById(R.id.tvBigPhoto);
        String photourl = getIntent().getStringExtra("url");
        String phototitle=getIntent().getStringExtra("title");
        ((TextView)findViewById(R.id.tvBigTitle)).setText(phototitle.toString());
        Picasso.with(this).load(photourl).into(bigphoto);


    }
}
