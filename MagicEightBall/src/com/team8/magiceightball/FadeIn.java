/* This is the fade in animation class. Not entirely sure the reason behind the
code so here's the original source: http://bit.ly/12BAy7l
*/

package com.team8.magiceightball;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class FadeIn {

	public static void runAlphaAnimation(Activity act, int viewId) {
		 
        Animation fadeInText  = AnimationUtils.loadAnimation(act, R.anim.fadein);
        if(fadeInText == null)
        	return;
        fadeInText.reset();
        
        View textField = act.findViewById(viewId);
        if (textField != null){
        	textField.clearAnimation();
        	textField.startAnimation(fadeInText);
        }
	}
}
