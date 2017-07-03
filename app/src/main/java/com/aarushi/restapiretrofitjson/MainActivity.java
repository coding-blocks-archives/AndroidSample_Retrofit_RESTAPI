package com.aarushi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aarushi.restapiretrofitjson.Adapters.AlbumsAdapter;

public class MainActivity extends AppCompatActivity {
    Button btnUsers,btnPosts,btnAlbums,btnTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsers=(Button)findViewById(R.id.btnUsers);
        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UserActivity.class));
            }
        });
        btnPosts=(Button)findViewById(R.id.btnPosts);
        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PostsActivity.class));
            }
        });
        btnAlbums=(Button)findViewById(R.id.btnAlbums);
        btnAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AlbumsActivity.class));
            }
        });
        btnTodos=(Button)findViewById(R.id.btnTodos);
        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TodosActivity.class));
            }
        });


    }
}
