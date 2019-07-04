package com.example.mcproject;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CheckListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_activity);

        TextView mobile_app_recommender = findViewById(R.id.mobile_app_recommender);
        mobile_app_recommender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeView = new Intent(v.getContext(),MobileRecommenderAppActivity.class);
                startActivity(changeView);
            }
        });
    }

}
