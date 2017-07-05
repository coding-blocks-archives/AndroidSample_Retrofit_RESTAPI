package com.example.dell.myappl11assign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullImageActivity extends AppCompatActivity {

    ImageView ivFullImagePhoto;
    TextView tvFullImageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        ivFullImagePhoto = (ImageView) findViewById(R.id.ivFullImagePhoto);
        tvFullImageTitle = (TextView) findViewById(R.id.tvFullImageTitle);

        String photoURLReceived = getIntent().getStringExtra("photoURL");
        if (photoURLReceived != null) {
            Picasso.with(FullImageActivity.this).load(photoURLReceived).error(R.drawable.ic_missing).into(ivFullImagePhoto);
        }
        String photoTitleReceived=getIntent().getStringExtra("photoTitle");
        if(photoTitleReceived!=null){
            tvFullImageTitle.setText(photoTitleReceived);
        }
    }
}
