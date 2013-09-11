package com.teamdev.mypub.activitys;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.teamdev.mypub.R;
import com.teamdev.mypub.fragments.ChooseSongFragment;
import com.teamdev.mypub.fragments.VoteFinished;
import com.teamdev.mypub.interfaces.VoteActivityListener;

public class VoteActivity extends SherlockFragmentActivity implements
		VoteActivityListener {

	private ChooseSongFragment mChooseFragment;
	private VoteFinished mVoteFinished;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.vote_activity);

		String placeName = getIntent().getExtras().getString(
				MainActivity.EXTRA_PLACE_NAME);
		if (placeName != null) {
			getSupportActionBar().setTitle(placeName);
		}
		
		initFragments();
	}

	private void initFragments() {
		mChooseFragment = new ChooseSongFragment();
		mChooseFragment.setListener(this);
		
		mVoteFinished  = new VoteFinished();
		VerifyChooseSong();
	}

	@Override
	public void VerifyChooseSong() {
		if (mChooseFragment.isVisible()) {
			return;
		}

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.vote_fragment_container, mChooseFragment)
				.commit();
	}

	@Override
	public void VerifyVoteFinished() {
		if (mVoteFinished.isVisible()) {
			return;
		}

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.vote_fragment_container, mVoteFinished)
				.commit();
	}

}
