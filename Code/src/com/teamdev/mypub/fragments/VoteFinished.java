package com.teamdev.mypub.fragments;

import com.teamdev.mypub.R;
import com.teamdev.mypub.utils.ResizeAnimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class VoteFinished extends Fragment {

	private View mLayout;
	private LinearLayout mBarsLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mLayout = inflater.inflate(R.layout.vote_finished_fragment, null);

		mBarsLayout = (LinearLayout) mLayout
				.findViewById(R.id.score_bars_layout);

		addBar(R.color.score_bar_blue);
		addBar(R.color.score_bar_red);
		addBar(R.color.score_bar_yellow);

		return mLayout;
	}

	public void addBar(int color) {
		View bar = new View(getActivity());
		LinearLayout.LayoutParams params = new LayoutParams(0, 0, 1f);
		params.gravity = Gravity.BOTTOM;
		bar.setLayoutParams(params);
		bar.setBackgroundResource(color);
		Animation animation = new ResizeAnimation(bar, 10, true);
		animation.setDuration(500);
		animation.setStartOffset(3000);
		bar.startAnimation(animation);
		mBarsLayout.addView(bar);
	}

}
