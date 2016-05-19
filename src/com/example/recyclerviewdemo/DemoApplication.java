package com.example.recyclerviewdemo;

import android.app.Application;

public class DemoApplication extends Application {

	
	private static DemoApplication mInstance;
	
	
	public static DemoApplication getInstance(){
		return mInstance;
	}
	
	@Override
	public void onCreate() {
		mInstance = this;
	}
}
