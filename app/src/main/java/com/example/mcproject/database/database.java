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

@Database(entities = {Checklist.class, event.class, Places.class, PlacesImages.class, to_do_list.class}, version = 18, exportSchema = false)
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

       for(to_do_list item : getToDoListData()){
           addTo_do_list(item,db);
       }

        for(Places item : getPlacesData()){
            addPlace(item,db);
        }

        for(PlacesImages item : getPlacesImageData()){
            addAPlace_image(item,db);
        }

        for(event item : getEventsData()){
            addEvent(item,db);
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

        Places item1 = new Places();
        item1.setPlace_name("Dalhousie University Bookstore");
        item1.setPlace_description("");
        item1.setPlace_ratings(4.3);
        item1.setPlace_type("Store");
        item1.setPlace_lat(44.637046);
        item1.setPlace_lng(-63.589257);
        PlacesItems.add(item1);

        Places item2 = new Places();
        item2.setPlace_name("Dalhousie University Bookstore");
        item2.setPlace_description("");
        item2.setPlace_ratings(4.3);
        item2.setPlace_type("Store");
        item2.setPlace_lat(44.637046);
        item2.setPlace_lng(-63.589257);
        PlacesItems.add(item2);

        Places item3 = new Places();
        item3.setPlace_name("Dalhousie University Bookstore");
        item3.setPlace_description("");
        item3.setPlace_ratings(4.3);
        item3.setPlace_type("Store");
        item3.setPlace_lat(44.637046);
        item3.setPlace_lng(-63.589257);
        PlacesItems.add(item3);

        Places item4 = new Places();
        item4.setPlace_name("Dalhousie University Bookstore");
        item4.setPlace_description("");
        item4.setPlace_ratings(4.3);
        item4.setPlace_type("Store");
        item4.setPlace_lat(44.637046);
        item4.setPlace_lng(-63.589257);
        PlacesItems.add(item4);

        Places item5 = new Places();
        item5.setPlace_name("Dalhousie University Bookstore");
        item5.setPlace_description("");
        item5.setPlace_ratings(4.3);
        item5.setPlace_type("Store");
        item5.setPlace_lat(44.637046);
        item5.setPlace_lng(-63.589257);
        PlacesItems.add(item5);

        Places item6 = new Places();
        item6.setPlace_name("Dalhousie University Bookstore");
        item6.setPlace_description("");
        item6.setPlace_ratings(4.3);
        item6.setPlace_type("Store");
        item6.setPlace_lat(44.637046);
        item6.setPlace_lng(-63.589257);
        PlacesItems.add(item6);

        Places item7 = new Places();
        item7.setPlace_name("Dalhousie University Bookstore");
        item7.setPlace_description("");
        item7.setPlace_ratings(4.3);
        item7.setPlace_type("Store");
        item7.setPlace_lat(44.637046);
        item7.setPlace_lng(-63.589257);
        PlacesItems.add(item7);

        Places item8 = new Places();
        item8.setPlace_name("Dalhousie University Bookstore");
        item8.setPlace_description("");
        item8.setPlace_ratings(4.3);
        item8.setPlace_type("Store");
        item8.setPlace_lat(44.637046);
        item8.setPlace_lng(-63.589257);
        PlacesItems.add(item8);

        Places item9 = new Places();
        item9.setPlace_name("Dalhousie University Bookstore");
        item9.setPlace_description("");
        item9.setPlace_ratings(4.3);
        item9.setPlace_type("Store");
        item9.setPlace_lat(44.637046);
        item9.setPlace_lng(-63.589257);
        PlacesItems.add(item9);

        Places item10 = new Places();
        item10.setPlace_name("Dalhousie University Bookstore");
        item10.setPlace_description("");
        item10.setPlace_ratings(4.3);
        item10.setPlace_type("Store");
        item10.setPlace_lat(44.637046);
        item10.setPlace_lng(-63.589257);
        PlacesItems.add(item10);

        Places item11 = new Places();
        item11.setPlace_name("Dalhousie University Bookstore");
        item11.setPlace_description("");
        item11.setPlace_ratings(4.3);
        item11.setPlace_type("Store");
        item11.setPlace_lat(44.637046);
        item11.setPlace_lng(-63.589257);
        PlacesItems.add(item11);

        Places item12 = new Places();
        item12.setPlace_name("Dalhousie University Bookstore");
        item12.setPlace_description("");
        item12.setPlace_ratings(4.3);
        item12.setPlace_type("Store");
        item12.setPlace_lat(44.637046);
        item12.setPlace_lng(-63.589257);
        PlacesItems.add(item12);

        Places item13 = new Places();
        item13.setPlace_name("Dalhousie University Bookstore");
        item13.setPlace_description("");
        item13.setPlace_ratings(4.3);
        item13.setPlace_type("Store");
        item13.setPlace_lat(44.637046);
        item13.setPlace_lng(-63.589257);
        PlacesItems.add(item13);

        Places item14 = new Places();
        item14.setPlace_name("Dalhousie University Bookstore");
        item14.setPlace_description("");
        item14.setPlace_ratings(4.3);
        item14.setPlace_type("Store");
        item14.setPlace_lat(44.637046);
        item14.setPlace_lng(-63.589257);
        PlacesItems.add(item14);

        Places item15 = new Places();
        item15.setPlace_name("Dalhousie University Bookstore");
        item15.setPlace_description("");
        item15.setPlace_ratings(4.3);
        item15.setPlace_type("Store");
        item15.setPlace_lat(44.637046);
        item15.setPlace_lng(-63.589257);
        PlacesItems.add(item15);

        Places item16 = new Places();
        item16.setPlace_name("Dalhousie University Bookstore");
        item16.setPlace_description("");
        item16.setPlace_ratings(4.3);
        item16.setPlace_type("Store");
        item16.setPlace_lat(44.637046);
        item16.setPlace_lng(-63.589257);
        PlacesItems.add(item16);

        Places item17 = new Places();
        item17.setPlace_name("Dalhousie University Bookstore");
        item17.setPlace_description("");
        item17.setPlace_ratings(4.3);
        item17.setPlace_type("Store");
        item17.setPlace_lat(44.637046);
        item17.setPlace_lng(-63.589257);
        PlacesItems.add(item17);

        Places item18 = new Places();
        item18.setPlace_name("Dalhousie University Bookstore");
        item18.setPlace_description("");
        item18.setPlace_ratings(4.3);
        item18.setPlace_type("Store");
        item18.setPlace_lat(44.637046);
        item18.setPlace_lng(-63.589257);
        PlacesItems.add(item18);

        Places item19 = new Places();
        item19.setPlace_name("Dalhousie University Bookstore");
        item19.setPlace_description("");
        item19.setPlace_ratings(4.3);
        item19.setPlace_type("Store");
        item19.setPlace_lat(44.637046);
        item19.setPlace_lng(-63.589257);
        PlacesItems.add(item19);

        Places item20 = new Places();
        item20.setPlace_name("Dalhousie University Bookstore");
        item20.setPlace_description("");
        item20.setPlace_ratings(4.3);
        item20.setPlace_type("Store");
        item20.setPlace_lat(44.637046);
        item20.setPlace_lng(-63.589257);
        PlacesItems.add(item20);





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

        to_do_list item1 = new to_do_list();
        item1.setTo_do_list_item("Check The Student Checklist");
        item1.setTo_do_list_source_id(0);
        item1.setTo_do_list_source_type("generated");
        ToDoListItems.add(item1);

        to_do_list item2 = new to_do_list();
        item2.setTo_do_list_item("Download Mobile recommended Apps");
        item2.setTo_do_list_source_id(0);
        item2.setTo_do_list_source_type("generated");
        ToDoListItems.add(item2);

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
