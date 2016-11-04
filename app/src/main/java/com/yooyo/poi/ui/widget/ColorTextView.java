package com.yooyo.poi.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yooyo.poi.R;

public class ColorTextView extends TextView {

    public ColorTextView(Context context) {
        super(context);
        registerChange();
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        registerChange();
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        registerChange();
    }

    protected void registerChange() {
        setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
    }

}
