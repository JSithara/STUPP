package com.example.mcproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.mcproject.database.database;
import com.example.mcproject.database.places.Places;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

public class CampusMapActivity extends FragmentActivity implements OnMapReadyCallback {

    public static GoogleMap mMap;
    public static Marker mMarker;
    public static List<Marker> PlaceMarkers = new ArrayList<Marker>();
    private FusedLocationProviderClient fusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campus_map_activity);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            LatLng CurrentLocation = new LatLng(44.636732, -63.591719);
            mMarker = mMap.addMarker(new MarkerOptions().position(CurrentLocation).icon(BitmapDescriptorFactory.fromResource(R.drawable.man_user)));
            mMap.setMinZoomPreference(15);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(CurrentLocation));
            Log.d("MAP API","Here");
        }else{
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                LatLng CurrentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                mMarker = mMap.addMarker(new MarkerOptions().position(CurrentLocation).icon(BitmapDescriptorFactory.fromResource(R.drawable.man_user)));
                                mMap.setMinZoomPreference(15);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(CurrentLocation));
                            }
                        }
                    });
        }
        List<Places> places = database.getAppDatabase(getApplicationContext()).placeDAO().getAll();
        for(Places place : places){
            LatLng CurrentLocation = new LatLng(place.place_lat, place.place_lng);
            Marker marker = mMap.addMarker(new MarkerOptions().position(CurrentLocation).title(place.getPlace_name()));
            PlaceMarkers.add(marker);
        }

    }
}
