package com.loyola.talktracer.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.loyola.blabbertabber.BuildConfig;
import com.loyola.blabbertabber.R;

/**
 * displays "About" BlabberTabber, including version & authors
 */
public class AboutActivity extends Activity {
    private static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
        TextView version = (TextView) findViewById(R.id.aboutVersion);
        version.setText(String.format("%s %s: %s\n",
                getString(R.string.app_name),
                getString(R.string.about_version),
                BuildConfig.VERSION_NAME));
    }

    public void finish(View v) {
        finish();
    }
}
