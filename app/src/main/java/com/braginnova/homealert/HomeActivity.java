package com.braginnova.homealert;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends Activity {

    TextView homeNameDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeNameDisplay = findViewById(R.id.home_name_display);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        final String homeName = bundle.getString("home_name");
        Log.v("Home Name", "homeName=" + homeName);
        homeNameDisplay.setText(homeName);

    }
}