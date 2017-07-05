package com.codingblocks.restapiretrofitjson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.codingblocks.restapiretrofitjson.adapters.UserAdapter;

/**
 * Created by Harshi on 7/5/2017.
 */

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "USERS";

    RecyclerView rvUserList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenUsers,btnOpenAlbums,btnOpenTodos,btnOpenPosts;

        btnOpenAlbums = (Button) findViewById(R.id.btnImages);
        btnOpenUsers = (Button) findViewById(R.id.btnUsers);
        btnOpenTodos = (Button) findViewById(R.id.btnTodos);
        btnOpenPosts = (Button) findViewById(R.id.btnPosts);

        btnOpenUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,UsersActivity.class);
                startActivity(i);
            }
        });

        btnOpenTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TodosActiviy.class);
                startActivity(i);
            }
        });

        btnOpenAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AlbumsActivity.class);
                startActivity(i);
            }
        });

        btnOpenPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PostsActivity.class);
                startActivity(i);
            }
        });

    }
}
