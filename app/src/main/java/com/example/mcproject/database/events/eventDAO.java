package com.example.mcproject.database.events;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface eventDAO {
    @Query("SELECT * FROM event")
    List<event> getAll();

    @Query("SELECT * FROM event WHERE event_id IN (:eventids)")
    List<event> loadAllByIds(int[] eventids);

    @Query("SELECT * FROM event WHERE event_name LIKE :event_name")
    event findByName(String event_name);

    @Query("SELECT * FROM event WHERE event_Description LIKE :event_Description")
    event findByDescription(String event_Description);

    @Query("SELECT * FROM event WHERE event_time = :event_time")
    event findByTime(String event_time);

    @Insert
    void insertAll(event... events);

    @Delete
    void delete(event events);
}
