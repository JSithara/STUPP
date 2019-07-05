package com.example.mcproject.database.events;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class event {
    @PrimaryKey
    public int event_id;

    public String event_name;
    public String place_id;
    public String event_time;
    public String event_Description;
    public String event_Banner_link;
}
