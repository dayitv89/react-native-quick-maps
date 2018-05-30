package com.quickmaps;

import android.view.MotionEvent;
import android.content.Context;

import com.facebook.react.views.view.ReactViewGroup;

public class BaseCustomView extends ReactViewGroup {
  public BaseCustomView(Context context) {
    super(context);
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
    return true;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return true;
  }
}
