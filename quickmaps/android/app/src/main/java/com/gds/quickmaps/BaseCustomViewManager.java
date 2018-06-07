package com.gds.quickmaps;

import android.graphics.Color;
import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class BaseCustomViewManager extends SimpleViewManager<MapView> {

    public static final String REACT_CLASS = "R2RBaseCustomView";

    private GoogleMap gmap;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected MapView createViewInstance(ThemedReactContext reactContext) {
        final GoogleMapOptions googleMapOptions = new GoogleMapOptions().liteMode(true);
        MapView  mapView = new MapView(reactContext, googleMapOptions);
        mapView.setBackgroundColor(Color.BLUE);
        MapsInitializer.initialize(reactContext.getCurrentActivity());
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                gmap.setMapType(googleMapOptions.getMapType());
                gmap.setMinZoomPreference(12);
                LatLng ny = new LatLng(40.7143528, -74.0059731);
                gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
            }
        });
        return mapView;

    }

    @ReactProp(name = "text")
    public void setText(View view, String mText) {
//        view.setText(mText);
    }
}
