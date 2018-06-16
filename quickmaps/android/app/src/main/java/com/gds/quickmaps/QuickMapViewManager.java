package com.gds.quickmaps;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;

public class QuickMapViewManager extends SimpleViewManager<QuickMapView> {

    public static final String REACT_CLASS = "R2RQuickMapView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected QuickMapView createViewInstance(ThemedReactContext reactContext) {
        GoogleMapOptions googleMapOptions = new GoogleMapOptions().mapType(GoogleMap.MAP_TYPE_NORMAL).liteMode(false);
        return new QuickMapView(reactContext,reactContext.getCurrentActivity(),googleMapOptions);

    }

    @ReactProp(name = "myLocationEnable", defaultBoolean = false)
    public void setMyLocationEnable(QuickMapView view, boolean isEnable) {
        view.setMyLocationEnable(isEnable);
    }
}
