package org.ruscoe.spacetrivia;

import org.ruscoe.spacetrivia.constants.Constants;
import org.ruscoe.spacetrivia.dao.CategoryData;
import org.ruscoe.spacetrivia.dao.UserPrefsData;
import org.ruscoe.spacetrivia.services.SoundService;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

/**
 * Displays the application options.
 * 
 * @author Dan Ruscoe
 */
public class OptionsActivity extends Activity implements OnClickListener {
	UserPrefsData userPrefsData;
	private CategoryData mCategoryData;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);

		userPrefsData = new UserPrefsData(this);

		CheckBox enableSound = (CheckBox) findViewById(R.id.enableSound);

		enableSound.setChecked(userPrefsData.isSoundEnabled());
		enableSound.setOnClickListener(this);

		setVolumeControlStream(AudioManager.STREAM_MUSIC);

		mCategoryData = new CategoryData(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (userPrefsData != null) {
			userPrefsData.close();
		}
	}

	@Override
	public void onClick(View v) {
		CheckBox checkbox = null;

		if (v.getId() == R.id.enableSound) {
			checkbox = (CheckBox) findViewById(R.id.enableSound);

			if (checkbox != null) {
				boolean enableSound = checkbox.isChecked();

				Log.d(Constants.APP_LOG_NAME, "Setting sound enabled: "
						+ enableSound);

				userPrefsData.setSoundEnabled(enableSound);

				SoundService.setSoundEnabled(enableSound);

				SoundService.playButtonClick();
			}
		}
	}

	public void reloadQuizzes() {
		mCategoryData.reloadQuizzes();
	}
}