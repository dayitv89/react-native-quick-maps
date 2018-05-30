package com.quickmaps;

import android.app.Activity;
import android.app.Fragment;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseCustomViewPackage implements ReactPackage {
    public BaseCustomViewPackage(Activity activity) {
    }

    public BaseCustomViewPackage() {
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        BaseCustomViewManager baseCustomViewManager = new BaseCustomViewManager();

        return Arrays.<ViewManager>asList(baseCustomViewManager);
    }
}
