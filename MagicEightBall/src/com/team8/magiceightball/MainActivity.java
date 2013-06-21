package com.team8.magiceightball;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Just a tester file to show what ResponseGenerator does.
 */
public class MainActivity extends Activity implements View.OnClickListener {
	TextView responseField;
	TextView instructions;
	ImageView generateImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		responseField = (TextView) findViewById(R.id.textView1);
		instructions = (TextView) findViewById(R.id.textView2);
		generateImage = (ImageView) findViewById(R.id.imageView1);
		generateImage.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		ResponseGenerator response = new ResponseGenerator();
		responseField.setText("test");
		if (v.getId() == R.id.imageView1) {
			responseField.setText(response.getResponse());
			Animate.startAnimation(this, R.id.imageView1);
		}
		FadeIn.runAlphaAnimation(this, R.id.textView1);
	}
}
