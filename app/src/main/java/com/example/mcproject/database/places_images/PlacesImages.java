package com.example.mcproject.database.places_images;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlacesImages {
    @PrimaryKey
    public int place_image_id;
    public String image_link;
    public String image_alt;
    public int place_id;
}
