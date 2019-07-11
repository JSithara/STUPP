package com.example.mcproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_activity);
        getSupportActionBar().setTitle("Events");
    }
}
