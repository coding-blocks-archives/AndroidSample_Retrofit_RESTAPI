package com.example.dell.myappl11assign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    Button btnUsers, btnPosts, btnAlbums, btnTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsers = (Button) findViewById(R.id.btnUsers);
        btnPosts = (Button) findViewById(R.id.btnPosts);
        btnAlbums = (Button) findViewById(R.id.btnAlbums);
        btnTodos = (Button) findViewById(R.id.btnTodos);


        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: *************");
                Intent i = new Intent(MainActivity.this, UsersActivity.class);
                startActivity(i);

            }
        });


        btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: **************");
                Intent i = new Intent(MainActivity.this, PostsActivity.class);
                startActivity(i);
            }
        });


        btnAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ***************");
                Intent i = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(i);
            }
        });


        btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: *****************");
                Intent i = new Intent(MainActivity.this, TodosActivity.class);
                startActivity(i);
            }
        });


    }
}
