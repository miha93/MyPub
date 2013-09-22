package com.teamdev.mypub;

import com.teamdev.mypub.async.AsyncRegister;

import android.app.Application;

public class MyPubApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		new AsyncRegister(this).execute();
	}
	
	

}
