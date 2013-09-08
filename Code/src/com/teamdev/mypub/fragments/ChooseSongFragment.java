package com.teamdev.mypub.fragments;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.teamdev.mypub.R;
import com.teamdev.mypub.adapters.ChooseSongsAdapter;
import com.teamdev.mypub.models.Song;

import de.passsy.holocircularprogressbar.HoloCircularProgressBar;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DigitalClock;
import android.widget.GridView;
import android.widget.TextView;

public class ChooseSongFragment extends Fragment {

	private final static long TIMER_DURATION = 60 * 1000; // 60s

	private View mLayout;
	private GridView mGridView;
	private ChooseSongsAdapter mAdapter;
	private List<Song> mSongs;
	private HoloCircularProgressBar mCircule;
	private TextView mClock;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mLayout = inflater.inflate(R.layout.choose_song_fragment, null);

		mGridView = (GridView) mLayout.findViewById(R.id.choose_song_grid);

		mSongs = new ArrayList<Song>();
		mAdapter = new ChooseSongsAdapter(getActivity(),
				R.layout.song_grid_item, mSongs);
		mGridView.setAdapter(mAdapter);

		mSongs.add(new Song("Wake Me Up", ""));
		mSongs.add(new Song("Wake Me Up", ""));
		mSongs.add(new Song("Wake Me Up", ""));
		mSongs.add(new Song("Wake Me Up", ""));
		mSongs.add(new Song("Wake Me Up", ""));

		mAdapter.notifyDataSetChanged();

		mCircule = (HoloCircularProgressBar) mLayout
				.findViewById(R.id.holoCircularProgressBar1);
		mClock = (TextView) mLayout.findViewById(R.id.choose_song_clock);

		animate(mCircule, new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {
				new CountDownTimer(TIMER_DURATION, 300) {

					@Override
					public void onTick(long millisUntilFinished) {
						DecimalFormat formatter = new DecimalFormat("00");
						long min = (millisUntilFinished / 1000) / 60;
						long sec = (millisUntilFinished / 1000)
								- (min * 1000 * 60);
						long millis = millisUntilFinished - -(min * 1000 * 60)
								- (sec * 1000);
						
						millis = millis / 10;

						String time = String.format("%s:%s:%s",
								formatter.format(min), formatter.format(sec),
								formatter.format(millis));
						mClock.setText(time);
					}

					@Override
					public void onFinish() {
						// TODO Auto-generated method stub

					}
				}.start();
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				getActivity().finish();
			}

			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub

			}
		});

		return mLayout;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void animate(final HoloCircularProgressBar progressBar,
			final AnimatorListener listener) {
		final ObjectAnimator progressBarAnimator = ObjectAnimator.ofFloat(
				progressBar, "progress", 1);
		progressBarAnimator.setDuration(TIMER_DURATION);

		progressBarAnimator.addListener(new AnimatorListener() {

			@Override
			public void onAnimationCancel(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animator animation) {
				progressBar.setProgress(1);
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub

			}

		});
		progressBarAnimator.addListener(listener);
		progressBarAnimator.reverse();
		progressBarAnimator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(final ValueAnimator animation) {
				progressBar.setProgress((Float) animation.getAnimatedValue());

			}
		});
		progressBar.setMarkerProgress(1);
		progressBarAnimator.start();
	}

}
