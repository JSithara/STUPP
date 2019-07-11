package com.example.mcproject.database.places;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Places {
    @PrimaryKey(autoGenerate = true)
    public int place_id;

    public String place_name;
    public String place_type;
    public String place_description;
    public int place_lat;
    public int place_lng;
    public String place_ratings;

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getPlace_lat() {
        return place_lat;
    }

    public int getPlace_lng() {
        return place_lng;
    }

    public String getPlace_description() {
        return place_description;
    }

    public String getPlace_name() {
        return place_name;
    }

    public String getPlace_ratings() {
        return place_ratings;
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_description(String place_description) {
        this.place_description = place_description;
    }

    public void setPlace_lat(int place_lat) {
        this.place_lat = place_lat;
    }

    public void setPlace_lng(int place_lng) {
        this.place_lng = place_lng;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public void setPlace_ratings(String place_ratings) {
        this.place_ratings = place_ratings;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }
}
