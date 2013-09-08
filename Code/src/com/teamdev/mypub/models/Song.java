package com.teamdev.mypub.models;

public class Song {
	
	private String mSongName;
	private String mArtistName;
	
	public Song(String songName, String artistName) {
		mSongName = songName;
		mArtistName = artistName;
	}

	public String getSongName() {
		return mSongName;
	}

	public void setSongName(String songName) {
		this.mSongName = songName;
	}

	public String getArtistName() {
		return mArtistName;
	}

	public void setArtistName(String artistName) {
		this.mArtistName = artistName;
	}
	
	

}
