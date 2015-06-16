package com.android.gif;


import java.io.InputStream;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.graphics.*;

public class GIFDemo extends GraphicsActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GIFView(this));
    }
    private static class GIFView extends View{
    	
    	Movie movie;
    	InputStream is=null;
    	long moviestart;
		public GIFView(Context context) {
			super(context);
			is=context.getResources().openRawResource(R.drawable.animated_gif);
			movie=Movie.decodeStream(is);
			//BitmapFactory.Options opts = new BitmapFactory.Options();
			//opts.inJustDecodeBounds = true;    // this will request the bm
	       // opts.inSampleSize = 10;   
			//movie=Movie.decodeFile("C:\\cartoon.gif");
		}
		
    	@Override
    	protected void onDraw(Canvas canvas) {
    		canvas.drawColor(0xFFCCCCCC);
    		super.onDraw(canvas);
    		long now=android.os.SystemClock.uptimeMillis();
    		System.out.println("now="+now);
    		 if (moviestart == 0) {   // first time
                 moviestart = now;
                 
             }
    		 System.out.println("\tmoviestart="+moviestart);
    		 int relTime = (int)((now - moviestart) % movie.duration()) ;
    		 System.out.println("time="+relTime+"\treltime="+movie.duration());
             movie.setTime(relTime);
             movie.draw(canvas,10,10);
             this.invalidate();
    	}
    }
}