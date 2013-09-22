package com.teamdev.mypub.models;

import android.graphics.drawable.Drawable;

public final class Place {
	
	private Drawable mIcon;
	private String mName;
	private String mAddress;
	private int mId;
	private boolean mVoteInProgress;
	
	public Place() {
		mName = "";
		mIcon = null;
		mAddress = "";
		mId = 0;
		mVoteInProgress = false;
	}

	public Drawable getIcon() {
		return mIcon;
	}

	public void setIcon(Drawable icon) {
		this.mIcon = icon;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getAddress() {
		return mAddress;
	}

	public void setAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public int getId() {
		return mId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public boolean isVoteInProgress() {
		return mVoteInProgress;
	}

	public void setVoteInProgress(boolean mVoteInProgress) {
		this.mVoteInProgress = mVoteInProgress;
	}
	
	

}
