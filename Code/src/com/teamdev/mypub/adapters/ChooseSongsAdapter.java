package com.teamdev.mypub.adapters;

import java.util.List;

import com.teamdev.mypub.R;
import com.teamdev.mypub.models.Song;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ChooseSongsAdapter extends ArrayAdapter<Song>{
	
	private LayoutInflater mLayoutInflater;
	private int mResId;

	public ChooseSongsAdapter(Context context, int resource, List<Song> objects) {
		super(context, resource, objects);
		mResId = resource;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView = mLayoutInflater.inflate(mResId, null);
		Song song = getItem(position);
		
		Button songButton = (Button) convertView.findViewById(R.id.choose_song_button);
		songButton.setText(song.getSongName());
		
		return convertView;
	}
	
	
	
	

}
