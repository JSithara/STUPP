package com.example.mcproject.database.places;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Places {
    @PrimaryKey
    public int place_id;

    public String place_name;
    public String place_type;
    public String place_description;
    public int place_lat;
    public int place_lng;
    public String place_ratings;
}
