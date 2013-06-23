package com.team8.magiceightball;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Just a tester file to show what ResponseGenerator does.
 */
public class MainActivity extends Activity {
	TextView responseField;
	TextView instructions;
	ImageView generateImage;
	private ShakeDetector mShakeDetector;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		responseField = (TextView) findViewById(R.id.textView1);
		instructions = (TextView) findViewById(R.id.textView2);
		generateImage = (ImageView) findViewById(R.id.imageView1);

		mShakeDetector = new ShakeDetector(new OnShakeListener() {

			@Override
			public void onShake() {
				runShake();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(mShakeDetector, mAccelerometer,
				SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause() {
		mSensorManager.unregisterListener(mShakeDetector);
		super.onPause();
	}

	public void runShake() {
		ResponseGenerator response = new ResponseGenerator();
		responseField.setText("test");

		responseField.setText(response.getResponse());
		Animate.startAnimation(this, R.id.imageView1);

		FadeIn.runAlphaAnimation(this, R.id.textView1);
	}
}
