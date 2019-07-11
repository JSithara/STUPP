package com.example.mcproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PlacesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_activity);
        getSupportActionBar().setTitle("Places");
    }
}
