package com.loyola.talktracer.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.loyola.blabbertabber.R;
import com.loyola.talktracer.model.Helper;

/**
 * The splash screen.
 * It is shown only the first time the application is opened.
 */
public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final String PREF_FIRST_TIME = "first_time";
    private static final String PREF_PROCESSORSPEED = "processing";
    public static boolean resetFirstTime = false;
    public static double processorSpeed = 1.0;
    private boolean mFirstTime = true;
    private int rushLimbaughIsWrongCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
        // http://developer.android.com/training/basics/data-storage/shared-preferences.html
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        mFirstTime = sharedPref.getBoolean(PREF_FIRST_TIME, mFirstTime);
        processorSpeed = (double) sharedPref.getFloat(PREF_PROCESSORSPEED, (float) processorSpeed);
        Log.i(TAG, "onResume() FirstTime: " + mFirstTime + "; Speed: " + processorSpeed);

        if (!mFirstTime && !resetFirstTime) {
            launchRecordingActivity();
        } else {
            // calculating processor speed takes 1/2 second, so we only want to incur this penalty
            // once, ever, and store it as a preference
            processorSpeed = Helper.howFastIsMyProcessor();
            Log.i(TAG, "onResume() Speed, first time calculation: " + processorSpeed);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(PREF_FIRST_TIME, mFirstTime);
        editor.putFloat(PREF_PROCESSORSPEED, (float) processorSpeed);
        editor.apply();
    }

    public void launchRecordingActivity() {
        Log.i(TAG, "launchRecordingActivity()");
        mFirstTime = false;
        resetFirstTime = false;

        Intent intent = new Intent(this, RecordingActivity.class);
        startActivity(intent);
    }

    // 2nd signature of launchRecordingActivity to accommodate activity_main.xml's
    // requirement to pass in a View (which is never used)
    public void launchRecordingActivity(View view) {
        launchRecordingActivity();
    }

    // Easter Egg for new users
    public void rushLimbaughIsWrong(View v) {
        Log.i(TAG, "rushLimbaughIsWrong()");
        rushLimbaughIsWrongCount += 1;
        if (rushLimbaughIsWrongCount > 3) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com/search?q=rush+limbaugh+wrong"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                Log.v(TAG, "rushLimbaughIsWrong(): resolved activity");
                startActivity(intent);
            } else {
                Log.v(TAG, "rushLimbaughIsWrong(): couldn't resolve activity");
            }
        }
    }

    // needed for testing
    public boolean getFirstTime() {
        return mFirstTime;
    }
}
