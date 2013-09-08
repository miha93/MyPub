package com.teamdev.mypub.activitys;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.teamdev.mypub.R;
import com.teamdev.mypub.fragments.ChooseSongFragment;

public class VoteActivity extends SherlockFragmentActivity {
	
	private ChooseSongFragment mChooseFragment;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.vote_activity);
		
		String placeName = getIntent().getExtras().getString(MainActivity.EXTRA_PLACE_NAME);
		if (placeName != null) {
			getSupportActionBar().setTitle(placeName);
		}
		
		mChooseFragment = new ChooseSongFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.vote_fragment_container, mChooseFragment).commit();

	}

}
