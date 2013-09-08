package com.teamdev.mypub.models;

import android.graphics.drawable.Drawable;

public final class Place {
	
	private Drawable mIcon;
	private String mName;
	
	public Place(String name, Drawable icon) {
		mName = name;
		mIcon = icon;
	}

	public Drawable getIcon() {
		return mIcon;
	}

	public void setmIcon(Drawable icon) {
		this.mIcon = icon;
	}

	public String getName() {
		return mName;
	}

	public void setmName(String name) {
		this.mName = name;
	}
	
	

}
