package com.android.gif;


import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

class GraphicsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressWarnings("unused")
	@Override
    public void setContentView(View view) {
        if (false) { // set to true to test Picture
            ViewGroup vg = new PictureLayout(this);
            vg.addView(view);
            view = vg;
        }
        
        super.setContentView(view);
    }
}

