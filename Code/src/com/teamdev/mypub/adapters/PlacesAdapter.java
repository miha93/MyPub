package com.teamdev.mypub.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamdev.mypub.R;
import com.teamdev.mypub.interfaces.MainActivityListner;
import com.teamdev.mypub.models.Place;

public class PlacesAdapter extends ArrayAdapter<Place> {
	
	private List<Place> mData;
	private LayoutInflater mLayoutInfalter;
	private int mResId;
	
	public PlacesAdapter(Context context, int resource, List<Place> objects) {
		super(context, resource, objects);
		mData = objects;
		mResId = resource;
		mLayoutInfalter = LayoutInflater.from(context);
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mLayoutInfalter.inflate(mResId, null);
		
		ImageView icon  = (ImageView) convertView.findViewById(R.id.place_icon);
		TextView name = (TextView) convertView.findViewById(R.id.place_name);
		
		Place place = getItem(position);
		icon.setImageDrawable(place.getIcon());
		name.setText(place.getName());
		
		return convertView;
	}	
}
