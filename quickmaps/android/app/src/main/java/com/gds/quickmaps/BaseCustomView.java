package com.gds.quickmaps;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.facebook.react.views.view.ReactViewGroup;

public class BaseCustomView extends ReactViewGroup {
    private TextView textView;
    public BaseCustomView(Context context, Activity activity) {
        super(context);
        textView = new TextView(context);
        textView.setText("Bharat Mata ki Jai");

        textView.setBackgroundColor(Color.BLUE);
        ReactViewGroup.LayoutParams layoutParams = new ReactViewGroup.LayoutParams(ReactViewGroup.LayoutParams.MATCH_PARENT,ReactViewGroup.LayoutParams.MATCH_PARENT);
        addView(textView,0,layoutParams);

    }


    public void setText(String mText){
        textView.setText(mText);
    }

}
