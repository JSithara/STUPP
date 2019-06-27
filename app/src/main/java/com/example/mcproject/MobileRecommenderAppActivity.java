package com.example.mcproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.TreeMap;

public class MobileRecommenderAppActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_app_recommender_activity);
        TreeMap<String,String> MobileAppData = SetMobileData();
        recyclerView = (RecyclerView) findViewById(R.id.mobile_app_recommender_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new HelpLineAdapter(MobileAppData);
        recyclerView.setAdapter(mAdapter);
    }

    private TreeMap<String,String> SetMobileData(){
        TreeMap<String,String> data = new TreeMap<String,String>();
        data.put("DalU",  "https://play.google.com/store/apps/details?id=edu.dalhousie.mobileapp&hl=en");
        data.put("Dal Safe",  "https://play.google.com/store/apps/details?id=com.cutcom.apparmor.dal&hl=en");
        return data;
    }
}
