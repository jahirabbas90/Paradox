package com.paradoxclient.paradox.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;


/**
 * Created by cattlefield on 16/9/16.
 */
public class mEditView extends AppCompatEditText {

    public mEditView(Context context) {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLight.ttf");
        this.setTypeface(face);
    }

    public mEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLight.ttf");
        this.setTypeface(face);
    }

    public mEditView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLight.ttf");
        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }
}
