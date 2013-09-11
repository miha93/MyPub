package com.teamdev.mypub.activitys;

import com.teamdev.mypub.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
	
	private final static int SPLASH_DURATION = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_splash);
        
        Handler handler = new Handler();
        
        Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				Intent intent =  new Intent(SplashActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
		
		handler.postDelayed(runnable, SPLASH_DURATION);
	}
	
	
}
