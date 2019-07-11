package com.example.mcproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mcproject.database.database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");
        ImageView Campus = findViewById(R.id.campus_icon);
        ImageView Events = findViewById(R.id.events_icon);
        ImageView Checklist = findViewById(R.id.check_list_icon);
        ImageView toDoList = findViewById(R.id.to_do_list_icon);
        ImageView places = findViewById(R.id.places_icon);
        ImageView HelpLine = findViewById(R.id.help_line_icon);
        Campus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(),CampusMapActivity.class);
                startActivity(changeView);
            }
        });
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(), EventsActivity.class);
                startActivity(changeView);
            }
        });
        Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(),CheckListActivity.class);
                startActivity(changeView);
            }
        });
        toDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(),ToDoListActivity.class);
                startActivity(changeView);
            }
        });
        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(), PlacesActivity.class);
                startActivity(changeView);
            }
        });
        HelpLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(),HelpLineActivity.class);
                startActivity(changeView);
            }
        });


    }
}
