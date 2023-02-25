package com.braginnova.homealert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class MainActivity extends Activity {

    String homeName;
    LinearLayout homeListLayout; Space spaceAfterHomeBar;
    TextView emptyHomeText, homeBarName, homeBarCount, homeBarCode;
    LinearLayout homeBar;
    boolean user = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyHomeText = new TextView(this);
        emptyHomeText.setText(R.string.emptyHomeText);
        emptyHomeText.setGravity(Gravity.CENTER);


        homeListLayout = findViewById(R.id.homeList);
        if(!user) {
            homeListLayout.addView(emptyHomeText);
        }
        else {
            for (int i=0; i<1; i++) {
                homeBar = new LinearLayout(this);
                homeBarName = new TextView(this);
                homeBarCode = new TextView(this);
                homeBarCount = new TextView(this);
                spaceAfterHomeBar = new Space(this);

                homeBar.setBackgroundColor(getResources().getColor(android.R.color.black));
                homeBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 260));
                homeBar.setOrientation(LinearLayout.VERTICAL);
                homeBar.setPadding(30,30,30,30);

                homeListLayout.addView(homeBar);

                homeBarName.setText(R.string.homeName);
                homeName = homeBarName.getText().toString();
                Log.v("Home Name", "homeName in Main =" + homeName);
                homeBarName.setPadding(10,10,10,10);
                homeBarCode.setText(R.string.home_code);
                homeBarCode.setPadding(10,10,10,10);
                homeBarCount.setText(R.string.home_count);
                homeBarCount.setPadding(10,10,10,10);
                homeBarCount.setGravity(Gravity.END);
                homeBar.addView(homeBarName);
                homeBar.addView(homeBarCode);
                homeBar.addView(homeBarCount);

                homeBar.setOnClickListener(view -> {
                    Intent i1 = new Intent(MainActivity.this, HomeActivity.class);
                    i1.putExtra("home_name", homeName);
                    startActivity(i1);
                });

                spaceAfterHomeBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 50));
                homeListLayout.addView(spaceAfterHomeBar);
            }
        }
    }

    public void onButtonClick(View v) {
        Intent i;
        if (v.getId() == R.id.createHome) {
            i = new Intent(this, CreateActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.joinHome) {
            i = new Intent(this, JoinActivity.class);
            startActivity(i);
        }
    }

}