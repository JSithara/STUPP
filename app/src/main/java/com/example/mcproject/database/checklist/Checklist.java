package com.example.mcproject.database.checklist;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Checklist {
    @PrimaryKey
    public int check_list_id;

    public String check_list_item;
    public String check_list_location;
    public String check_list_status;
}
