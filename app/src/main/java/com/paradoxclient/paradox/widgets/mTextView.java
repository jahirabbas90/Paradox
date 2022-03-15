package com.paradoxclient.paradox.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


/**
 * Created by Jahir on 16/9/18.
 */
public class mTextView extends AppCompatTextView {


    public mTextView(Context context) {
        super(context);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "Gotham Regular.otf");
        this.setTypeface(face);
    }

    public mTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "Gotham Regular.otf");
        this.setTypeface(face);
    }

    public mTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //Typeface face= Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        Typeface face= Typeface.createFromAsset(context.getAssets(), "Gotham Regular.otf");

        this.setTypeface(face);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);


    }
}
