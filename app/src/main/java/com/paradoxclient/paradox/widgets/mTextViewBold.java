package com.paradoxclient.paradox.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by Jahir on 12/08/18.
 */

public class mTextViewBold extends AppCompatTextView {


  public mTextViewBold(Context context) {
    super(context);
    Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamBold.ttf");
    this.setTypeface(face);
  }

  public mTextViewBold(Context context, AttributeSet attrs) {
    super(context, attrs);
    Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamBold.ttf");
    this.setTypeface(face);
  }

  public mTextViewBold(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    Typeface face= Typeface.createFromAsset(context.getAssets(), "GothamBold.ttf");

    this.setTypeface(face);
  }

  protected void onDraw (Canvas canvas) {
    super.onDraw(canvas);


  }
}