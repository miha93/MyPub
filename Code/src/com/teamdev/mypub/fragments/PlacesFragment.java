package com.teamdev.mypub.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.extras.listfragment.PullToRefreshListFragment;
import com.teamdev.mypub.R;
import com.teamdev.mypub.adapters.PlacesAdapter;
import com.teamdev.mypub.interfaces.MainActivityListner;
import com.teamdev.mypub.models.Place;

public class PlacesFragment extends PullToRefreshListFragment {
	
	private PlacesAdapter mAdapter;
	private List<Place> mPlaces;
	private MainActivityListner mListner;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPlaces = new ArrayList<Place>();
		mPlaces.add(new Place("Mishkas Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mPlaces.add(new Place("Alexs Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mPlaces.add(new Place("Natans Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mPlaces.add(new Place("My Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mPlaces.add(new Place("Dads Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mPlaces.add(new Place("Moms Pub", getResources().getDrawable(R.drawable.pub_icon)));
		mAdapter = new PlacesAdapter(getActivity(), R.layout.place_list_item, mPlaces);
		setListAdapter(mAdapter);
	}
	
	public void setListner(MainActivityListner listner) {
		mListner = listner;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mListner.openVoteActivity(mPlaces.get(position - 1).getName());
	}
	
	
	
	
	
	

}
