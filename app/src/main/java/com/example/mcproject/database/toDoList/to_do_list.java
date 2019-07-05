package com.example.mcproject.database.toDoList;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class to_do_list {
    @PrimaryKey
    public int to_do_list_id;
    public String to_do_list_item;
    public String to_do_list_source_type;
    public int to_do_list_source_id;
}
