package org.ruscoe.spacetrivia;

import org.ruscoe.spacetrivia.dao.UserPrefsData;
import org.ruscoe.spacetrivia.services.SoundService;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * The main application activity. Displays the title menu and allows the user to
 * start a trivia round.
 * 
 * @author Dan Ruscoe
 */
public class MainActivity extends Activity {
	private UserPrefsData userPrefsData;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		userPrefsData = new UserPrefsData(this);

		SoundService.loadSound(this);
		SoundService.setSoundEnabled(userPrefsData.isSoundEnabled());

		// Allow the user to control the media volume of their device.
		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		SoundService.playBackgroundSound();

		// for title, use custom font
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/heliotypeletplain-1.0.ttf");
		TextView tv = (TextView) findViewById(R.id.eclipse_phase_trivia);
		tv.setTypeface(tf);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		SoundService.release();

		if (userPrefsData != null) {
			userPrefsData.close();
		}
	}

	/**
	 * Displays the trivia categories list.
	 * 
	 * @param View
	 *            view - The current view.
	 */
	public void showCategories(View view) {
		SoundService.playStartSound();

		Intent i = new Intent(view.getContext(), CategoriesActivity.class);
		startActivity(i);
	}

	/**
	 * Displays the trivia scores list.
	 * 
	 * @param View
	 *            view - The current view.
	 */
	public void showScores(View view) {
		SoundService.playStartSound();

		Intent i = new Intent(view.getContext(), ScoresActivity.class);
		startActivity(i);
	}

	/**
	 * Displays the options menu.
	 * 
	 * @param View
	 *            view - The current view.
	 */
	public void showOptions(View view) {
		SoundService.playStartSound();

		Intent i = new Intent(view.getContext(), OptionsActivity.class);
		startActivity(i);
	}
}