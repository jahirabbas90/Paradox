package com.paradoxclient.paradox.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class mTextViewLight extends AppCompatTextView {


    public mTextViewLight(Context context) {
        super(context);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLightItalic.ttf");
        this.setTypeface(face);
    }

    public mTextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLightItalic.ttf");
        this.setTypeface(face);
    }

    public mTextViewLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamLightItalic.ttf");

        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }
}
