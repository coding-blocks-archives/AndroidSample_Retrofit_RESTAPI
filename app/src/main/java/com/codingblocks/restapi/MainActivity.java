package com.codingblocks.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.codingblocks.restapi.activities.AlbumsActivity;
import com.codingblocks.restapi.activities.PostsActivity;
import com.codingblocks.restapi.activities.TodosActivity;
import com.codingblocks.restapi.activities.UsersActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPosts, btnUsers, btnAlbums, btnTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUsers = (ImageButton) findViewById(R.id.btnUsers);
        btnPosts = (ImageButton) findViewById(R.id.btnPosts);
        btnAlbums = (ImageButton) findViewById(R.id.btnAlbums);
        btnTodos = (ImageButton) findViewById(R.id.btnTodos);

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;
                switch (view.getId()) {
                    case R.id.btnAlbums:
                        i = new Intent(MainActivity.this, AlbumsActivity.class);
                        break;
                    case R.id.btnPosts:
                        i = new Intent(MainActivity.this, PostsActivity.class);
                        break;
                    case R.id.btnTodos:
                        i = new Intent(MainActivity.this, TodosActivity.class);
                        break;
                    case R.id.btnUsers:
                        i = new Intent(MainActivity.this, UsersActivity.class);
                        break;

                }
                startActivity(i);
            }
        };

        btnTodos.setOnClickListener(onButtonClickListener);
        btnAlbums.setOnClickListener(onButtonClickListener);
        btnPosts.setOnClickListener(onButtonClickListener);
        btnUsers.setOnClickListener(onButtonClickListener);

    }
}
