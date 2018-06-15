package com.gds.quickmaps;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;

public class QuickMapView extends MapView implements LifecycleEventListener,GoogleMap.InfoWindowAdapter,
        GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnPoiClickListener {

    private static final String[] LOCATION_PERMISSIONS = new String[]{
            "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private GoogleMap googleMap;
    private boolean myLocationEnabled = false;

    public QuickMapView(Context context, Activity activity,GoogleMapOptions googleMapOptions) {
        super(context,googleMapOptions);
        this.onCreate(null);
        this.onResume();
        this.getMapAsync(this);
    }

    @Override
    public void onHostResume() {
        if (hasPermissions()) {
            googleMap.setMyLocationEnabled(myLocationEnabled);
        }
        this.onResume();
    }

    @Override
    public void onHostPause() {
        if (hasPermissions()) {
            //noinspection MissingPermission
            googleMap.setMyLocationEnabled(false);
        }
        this.onPause();
    }

    @Override
    public void onHostDestroy() {
        this.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if(hasPermissions()){
            googleMap.setMyLocationEnabled(true);
        }
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setAllGesturesEnabled(true);

        LatLng ny = new LatLng(40.7143528, -74.0059731);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(ny);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ny));
    }


    public void setMyLocationEnable(boolean showUserLocation) {
        this.myLocationEnabled = showUserLocation; // hold onto this for lifecycle handling
        if (hasPermissions()) {
            //noinspection MissingPermission
            googleMap.setMyLocationEnabled(showUserLocation);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public void onPoiClick(PointOfInterest pointOfInterest) {

    }

    private boolean hasPermissions() {
        return checkSelfPermission(getContext(), LOCATION_PERMISSIONS[0]) == PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(getContext(), LOCATION_PERMISSIONS[1]) == PackageManager.PERMISSION_GRANTED;
    }
}
