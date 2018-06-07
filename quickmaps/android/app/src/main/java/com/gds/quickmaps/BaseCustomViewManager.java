package com.gds.quickmaps;

import android.graphics.Color;
import android.view.View;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
        final MapView  mapView = new MapView(reactContext, googleMapOptions);
        mapView.setBackgroundColor(Color.BLUE);
        MapsInitializer.initialize(reactContext.getCurrentActivity());
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                gmap.setMinZoomPreference(10);
                gmap.setIndoorEnabled(true);
                UiSettings uiSettings = gmap.getUiSettings();
                uiSettings.setIndoorLevelPickerEnabled(true);
                uiSettings.setMyLocationButtonEnabled(true);
                uiSettings.setMapToolbarEnabled(true);
                uiSettings.setCompassEnabled(true);
                uiSettings.setZoomControlsEnabled(true);

                LatLng ny = new LatLng(40.7143528, -74.0059731);

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(ny);
                gmap.addMarker(markerOptions);

                gmap.moveCamera(CameraUpdateFactory.newLatLng(ny));
            }
        });
        mapView.onCreate(null);
        reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            @Override
            public void onHostResume() {
                mapView.onResume();
            }

            @Override
            public void onHostPause() {
                mapView.onPause();
            }

            @Override
            public void onHostDestroy() {
                mapView.onDestroy();
            }
        });

        return mapView;

    }

    @ReactProp(name = "text")
    public void setText(View view, String mText) {
//        view.setText(mText);
    }
}
