package com.quickmaps;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class BaseCustomViewManager extends SimpleViewManager<BaseCustomView> {

    public static final String REACT_CLASS = "R2RBaseCustomView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected BaseCustomView createViewInstance(
            ThemedReactContext reactContext) {
        return new BaseCustomView(reactContext);
    }
}
