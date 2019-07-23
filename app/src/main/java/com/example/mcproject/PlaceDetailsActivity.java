package com.example.mcproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mcproject.database.database;
import com.example.mcproject.database.places.Places;

public class PlaceDetailsActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    TextView ratings;
    ImageView imageView;
    Button navigate;
    Button imageToggle;
    ImageView place_image;
    int place_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_details_activity);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            place_id = extras.getInt("place_id");
        }
        getSupportActionBar().setTitle("Place Details");
         Places place = database.getAppDatabase(getApplicationContext()).placeDAO().loadById(place_id);
         title = findViewById(R.id.place_detail_title);
         description = findViewById(R.id.place_detail_description);
         ratings = findViewById(R.id.place_detail_ratings);
         navigate = findViewById(R.id.place_detail_navigate_button);
         imageToggle = findViewById(R.id.place_detail_toggle);
         place_image  = findViewById(R.id.place_detail_image);
         title.setText(place.getPlace_name());
         description.setText(place.getPlace_description());
         ratings.setText(place.getPlace_ratings()+"");

         navigate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

         imageToggle.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });


    }
}
