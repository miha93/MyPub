package com.teamdev.mypub.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.SearchView;
import com.teamdev.mypub.R;
import com.teamdev.mypub.fragments.PlacesFragment;
import com.teamdev.mypub.interfaces.MainActivityListner;

public class MainActivity extends SherlockFragmentActivity implements
		ActionBar.TabListener, MainActivityListner {
	
	public final static String EXTRA_PLACE_NAME = "EXTRA PLACE";

	private PlacesFragment mPlaceFragment;
	private SearchView mSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPlaceFragment = new PlacesFragment();
		mPlaceFragment.setListner(this);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.main_fragment_container, mPlaceFragment).commit();

		initActionBar();
	}

	private void initActionBar() {
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		Tab mPubs = actionBar.newTab().setText("Pubs").setTabListener(this);
		actionBar.addTab(mPubs);

		Tab mFavorites = actionBar.newTab().setText("Favorites")
				.setTabListener(this);
		actionBar.addTab(mFavorites);

		Tab mRecents = actionBar.newTab().setText("Recents")
				.setTabListener(this);
		actionBar.addTab(mRecents);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mSearch = new SearchView(getSupportActionBar().getThemedContext());
		mSearch.setIconifiedByDefault(true);

		menu.add("Search").setActionView(mSearch)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openVoteActivity(String placeName) {
		Intent intent = new Intent(this, VoteActivity.class);
		intent.putExtra(EXTRA_PLACE_NAME, placeName);
		startActivity(intent);
	}

}
