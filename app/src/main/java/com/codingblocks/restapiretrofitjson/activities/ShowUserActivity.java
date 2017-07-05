package com.codingblocks.restapiretrofitjson.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codingblocks.restapiretrofitjson.R;
import com.codingblocks.restapiretrofitjson.api.API;
import com.codingblocks.restapiretrofitjson.models.User;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowUserActivity extends AppCompatActivity implements OnMapReadyCallback{
    TextView tvName, tvUsername, tvEmail, tvPhone, tvStreet, tvSuite, tvCity, tvZip;
    GoogleMap Map;

    User user;
    LatLng location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        tvName = (TextView) findViewById(R.id.tvName);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvStreet = (TextView) findViewById(R.id.tvStreet);
        tvSuite = (TextView) findViewById(R.id.tvSuite);
        tvCity = (TextView) findViewById(R.id.tvCity);
        tvZip = (TextView) findViewById(R.id.tvZip);

        SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragMap);
        mapFrag.getMapAsync(this);

        int userId = getIntent().getIntExtra("userId", 0);

        API.getInstance().getUsersAPI().getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();

                tvName.setText(user.getName());
                tvUsername.setText(user.getUsername());
                tvEmail.setText(user.getEmail());
                tvPhone.setText(user.getPhone());
                tvStreet.setText(user.getAddress().getStreet());
                tvSuite.setText(user.getAddress().getSuite());
                tvCity.setText(user.getAddress().getCity());
                tvZip.setText(user.getAddress().getZipcode());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Map = googleMap;

        API.getInstance().getUsersAPI().getUser(getIntent().getIntExtra("userId", 0)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                location = new LatLng(
                        Double.valueOf(response.body().getAddress().getGeo().getLat()),
                        Double.valueOf(response.body().getAddress().getGeo().getLng())
                );

                Map.addMarker(new MarkerOptions().position(location));
                Map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                        .target(location)
                        .zoom(10)
                        .build()
                ));
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
