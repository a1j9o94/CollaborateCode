package com.team8.magiceightball;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Animate {
    public static void startAnimation(Activity act, int viewId){
    	ImageView imageAni = (ImageView) act.findViewById(viewId);
    	// set foreground image to blank since animation uses background
    	imageAni.setImageResource(R.drawable.blank);
    	imageAni.setBackgroundResource(R.drawable.animations);
    	AnimationDrawable frameAnimation = (AnimationDrawable) imageAni.getBackground();
    	// stop/reset any previous animation runs
    	frameAnimation.stop();
    	frameAnimation.start();
    }
}
