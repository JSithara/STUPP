package com.example.mcproject.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mcproject.database.checklist.Checklist;
import com.example.mcproject.database.checklist.ChecklistDAO;
import com.example.mcproject.database.events.event;
import com.example.mcproject.database.events.eventDAO;
import com.example.mcproject.database.places.Places;
import com.example.mcproject.database.places.placesDAO;
import com.example.mcproject.database.places_images.PlacesImages;
import com.example.mcproject.database.places_images.PlacesImagesDAO;
import com.example.mcproject.database.toDoList.to_do_list;
import com.example.mcproject.database.toDoList.to_do_listDAO;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Checklist.class, event.class, Places.class, PlacesImages.class, to_do_list.class}, version = 4, exportSchema = false)
public abstract class database extends RoomDatabase {
    private static database INSTANCE;

    public abstract ChecklistDAO checklistDAO();
    public abstract eventDAO eventDAO();
    public abstract placesDAO placeDAO();
    public abstract PlacesImagesDAO place_imageDAO();
    public abstract to_do_listDAO to_do_listDAO();

    public static database getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), database.class, "database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
            if(isCheckListEmpty(INSTANCE)){
                populateDatabase(INSTANCE);
            }

        }
        return INSTANCE;
    }

    private static void addEvent(event input,final database db){
        db.eventDAO().insertAll(input);
    }

    private static void addCheckList(Checklist input,final database db){
        db.checklistDAO().insertAll(input);
    }

    private static void addPlace(Places input,final database db){
        db.placeDAO().insertAll(input);
    }

    private static void addTo_do_list(to_do_list input,final database db){
        db.to_do_listDAO().insertAll(input);
    }

    private static void addAPlace_image(PlacesImages input,final database db){
        db.place_imageDAO().insertAll(input);
    }

    private static void populateDatabase(final database db){
       for(Checklist item : getChecklistData()){
           addCheckList(item,db);
       }
    }

    private static List<Checklist> getChecklistData(){
        List<Checklist> CheckListItems= new ArrayList<Checklist>();

        Checklist item1 = new Checklist();
        item1.setCheck_list_item("Get Student ID Card");
        item1.setCheck_list_location("Howe Hall 6230 Coburg Rd");
        item1.setCheck_list_status("Not Done");
        CheckListItems.add(item1);

        Checklist item2 = new Checklist();
        item2.setCheck_list_item("Get Your Bus Pass");
        item2.setCheck_list_location("Howe Hall 6230 Coburg Rd");
        item2.setCheck_list_status("Not Done");
        CheckListItems.add(item2);

        Checklist item3 = new Checklist();
        item3.setCheck_list_item("Register For Your Courses");
        item3.setCheck_list_location("cas.dal.ca");
        item3.setCheck_list_status("Not Done");
        CheckListItems.add(item3);

        Checklist item4 = new Checklist();
        item4.setCheck_list_item("Dalhousie Orientation Week");
        item4.setCheck_list_location("Student Union Building");
        item4.setCheck_list_status("Not Done");
        CheckListItems.add(item4);

        Checklist item5 = new Checklist();
        item5.setCheck_list_item("Book Residence On Campus");
        item5.setCheck_list_location("dal.ca/residence");
        item5.setCheck_list_status("Not Done");
        CheckListItems.add(item5);

        Checklist item6 = new Checklist();
        item6.setCheck_list_item("Book Residence Off Campus");
        item6.setCheck_list_location("dal.ca/campus_life/residence_housing/off-campus-living.html");
        item6.setCheck_list_status("Not Done");
        CheckListItems.add(item6);

        Checklist item7 = new Checklist();
        item7.setCheck_list_item("Accept or waive your health insurance");
        item7.setCheck_list_location("cas.dal.ca");
        item7.setCheck_list_status("Not Done");
        CheckListItems.add(item7);
        //
        Checklist item8 = new Checklist();
        item8.setCheck_list_item("Pay your tuition & fees");
        item8.setCheck_list_location("cas.dal.ca");
        item8.setCheck_list_status("Not Done");
        CheckListItems.add(item8);
        return CheckListItems;
    }

    private static List<event> getEventsData(){
        List<event> EventsItems= new ArrayList<event>();

//        Checklist item1 = new Checklist();
//        item1.setCheck_list_item("Get Student ID Card");
//        item1.setCheck_list_location("Howe Hall 6230 Coburg Rd");
//        item1.setCheck_list_status("Not Done");
//        CheckListItems.add(item1);

        return EventsItems;
    }

    private static List<Places> getPlacesData(){
        List<Places> PlacesItems= new ArrayList<Places>();

//        Checklist item1 = new Checklist();
//        item1.setCheck_list_item("Get Student ID Card");
//        item1.setCheck_list_location("Howe Hall 6230 Coburg Rd");
//        item1.setCheck_list_status("Not Done");
//        CheckListItems.add(item1);

        return PlacesItems;
    }

    private static List<PlacesImages> getPlacesImageData(){
        List<PlacesImages> PlacesImagesItems= new ArrayList<PlacesImages>();

//        Checklist item1 = new Checklist();
//        item1.setCheck_list_item("Get Student ID Card");
//        item1.setCheck_list_location("Howe Hall 6230 Coburg Rd");
//        item1.setCheck_list_status("Not Done");
//        CheckListItems.add(item1);

        return PlacesImagesItems;
    }

    private static List<to_do_list> getToDoListData(){
        List<to_do_list> ToDoListItems= new ArrayList<to_do_list>();

//        Checklist item1 = new Checklist();
//        item1.setCheck_list_item("Get Student ID Card");
//        item1.setCheck_list_location("Howe Hall 6230 Coburg Rd");
//        item1.setCheck_list_status("Not Done");
//        CheckListItems.add(item1);

        return ToDoListItems;
    }
    private static boolean isCheckListEmpty(database INSTANCE){
        if(INSTANCE.checklistDAO().getAll().size()==0){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isEventEmpty(database INSTANCE){
        if(INSTANCE.eventDAO().getAll().size()==0){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isPlaceEmpty(database INSTANCE){
        if(INSTANCE.placeDAO().getAll().size()==0){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isPlaceImageEmpty(database INSTANCE){
        if(INSTANCE.place_imageDAO().getAll().size()==0){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isToDoListEmpty(database INSTANCE){
        if(INSTANCE.to_do_listDAO().getAll().size()==0){
            return true;
        }else{
            return false;
        }
    }

    public static void destroyInstance() {

        INSTANCE = null;
    }

}
