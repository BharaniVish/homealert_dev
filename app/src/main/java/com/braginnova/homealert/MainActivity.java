package com.braginnova.homealert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout homeListLayout;
    TextView emptyHomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyHomeText = new TextView(this);
        emptyHomeText.setText(R.string.emptyHomeText);
        emptyHomeText.setGravity(Gravity.CENTER);
        //emptyHomeText.setId(View.generateViewId());


        homeListLayout = findViewById(R.id.homeList);
        homeListLayout.addView(emptyHomeText);
    }

    public void onButtonClick(View v) {
        Intent i;
        if (v.getId() == R.id.createHome) {
            i = new Intent(this, CreateActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.joinHome) {
            i = new Intent(this, CreateActivity.class);
            startActivity(i);
        }
    }

}