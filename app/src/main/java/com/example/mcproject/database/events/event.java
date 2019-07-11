package com.example.mcproject.database.events;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class event {
    @PrimaryKey(autoGenerate = true)
    public int event_id;

    public String event_name;
    public String place_id;
    public String event_time;
    public String event_date;
    public String event_Description;
    public String event_Banner_link;

    public int getEvent_id() {
        return event_id;
    }

    public String getEvent_Banner_link() {
        return event_Banner_link;
    }

    public String getEvent_Description() {
        return event_Description;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_time() {
        return event_time;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_Banner_link(String event_Banner_link) {
        this.event_Banner_link = event_Banner_link;
    }

    public void setEvent_Description(String event_Description) {
        this.event_Description = event_Description;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }
}
