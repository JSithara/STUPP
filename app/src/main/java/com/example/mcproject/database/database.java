package com.example.mcproject.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mcproject.database.checklist.Checklist;
import com.example.mcproject.database.checklist.ChecklistDAO;
import com.example.mcproject.database.events.event;
import com.example.mcproject.database.places.Places;
import com.example.mcproject.database.places_images.PlacesImages;
import com.example.mcproject.database.toDoList.to_do_list;

@Database(entities = {Checklist.class, event.class, Places.class, PlacesImages.class, to_do_list.class}, version = 2)
public abstract class database extends RoomDatabase {
    private static database INSTANCE;

    public abstract ChecklistDAO checklistDAO();
}
