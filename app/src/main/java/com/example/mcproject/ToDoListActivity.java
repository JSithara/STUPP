package com.example.mcproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mcproject.database.database;
import com.example.mcproject.database.toDoList.to_do_list;

import java.util.List;

public class ToDoListActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter mAdapter;
    public RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list_activity);

        List<to_do_list> Data = database.getAppDatabase(getApplicationContext()).to_do_listDAO().getAll();
        Log.d("Data_list_COUNT",Data.size()+"");
        recyclerView = (RecyclerView) findViewById(R.id.to_do_list_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ToDoListAdapter(Data);
        recyclerView.setAdapter(mAdapter);

        ImageView insert = findViewById(R.id.insert_to_do_list);
        TextView textView = findViewById(R.id.to_do_list_text_view);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
