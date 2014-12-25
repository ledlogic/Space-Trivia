package org.ruscoe.spacetrivia.services;

import org.ruscoe.spacetrivia.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundService {
	private static SoundPool mSounds;
	private static int mBackground;
	private static int mClick;
	private static int mSuccess;
	private static int mFailure;
	private static int mStart;
	private static int mSummary;
	private static int mClose;

	private static boolean mSoundEnabled = true;

	public static void loadSound(Context context) {
		mSounds = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		mBackground = mSounds.load(context, R.raw.computer_sensorsweep, 1);
		mClick = mSounds.load(context, R.raw.computer_beep_videobeep, 1);
		mSuccess = mSounds.load(context, R.raw.computer_open_openbeep, 1);
		mFailure = mSounds.load(context, R.raw.computer_error_comp2, 1);
		mStart = mSounds.load(context, R.raw.computer_start_comp3, 1);
		mSummary = mSounds.load(context, R.raw.computer_process_comp1, 1);
		mClose = mSounds.load(context, R.raw.computer_close_closebeep, 1);
	}

	public static void playCloseSound() {
		if (mSoundEnabled) {
			mSounds.play(mClose, 1, 1, 1, 0, 1);
		}
	}

	public static void playSummarySound() {
		if (mSoundEnabled) {
			mSounds.play(mSummary, 1, 1, 1, 0, 1);
		}
	}

	public static void playStartSound() {
		if (mSoundEnabled) {
			mSounds.play(mStart, 1, 1, 1, 0, 1);
		}
	}

	public static void playBackgroundSound() {
		if (mSoundEnabled) {
			mSounds.play(mBackground, 1, 1, 1, 0, 1);
		}
	}

	public static void playButtonClick() {
		if (mSoundEnabled) {
			mSounds.play(mClick, 1, 1, 1, 0, 1);
		}
	}

	public static void playButtonClickSuccess() {
		if (mSoundEnabled) {
			mSounds.play(mSuccess, 1, 1, 1, 0, 1);
		}
	}

	public static void playButtonClickFailure() {
		if (mSoundEnabled) {
			mSounds.play(mFailure, 1, 1, 1, 0, 1);
		}
	}

	/**
	 * Should be called in onDestroy method of Activity.
	 */
	public static final void release() {
		if (mSoundEnabled) {
			mSounds.release();
		}
	}

	public static final void setSoundEnabled(boolean enabled) {
		mSoundEnabled = enabled;
	}
}
