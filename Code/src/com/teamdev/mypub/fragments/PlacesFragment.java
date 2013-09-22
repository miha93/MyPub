package com.teamdev.mypub.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.handmark.pulltorefresh.extras.listfragment.PullToRefreshListFragment;
import com.teamdev.mypub.R;
import com.teamdev.mypub.adapters.PlacesAdapter;
import com.teamdev.mypub.async.AsyncGetPubs;
import com.teamdev.mypub.interfaces.GetPlacesListener;
import com.teamdev.mypub.interfaces.MainActivityListner;
import com.teamdev.mypub.models.Place;

public class PlacesFragment extends PullToRefreshListFragment implements GetPlacesListener {
	
	private PlacesAdapter mAdapter;
	private List<Place> mPlaces;
	private MainActivityListner mListner;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPlaces = new ArrayList<Place>();
		mAdapter = new PlacesAdapter(getActivity(), R.layout.place_list_item, mPlaces);
		setListAdapter(mAdapter);
		new AsyncGetPubs(getActivity(), this).execute();
	}
	
	public void setListner(MainActivityListner listner) {
		mListner = listner;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mListner.openVoteActivity(mPlaces.get(position - 1).getName());
	}

	@Override
	public void setPlaces(List<Place> list) {
		mPlaces.clear();
		mPlaces.addAll(list);
		mAdapter.notifyDataSetChanged();
		mAdapter.getCount();
	}
	
	
	
	
	
	

}
