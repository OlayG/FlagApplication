package com.noname.flagapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Here are my constants to keep track of my fragments
    public static final String FRAG_TOP = "FRAG_TOP";
    public static final String FRAG_MIDDLE = "FRAG_MIDDLE";
    public static final String FRAG_BOTTOM = "FRAG_BOTTOM";

    // Here I declare variables for my FrameLayout (this is where my fragments will be loaded too)
    FrameLayout top, middle, bottom;
    // Here I declare my variables for FlagColorFragment (this is my fragments)
    FlagColorFragment fragTop, fragMiddle, fragBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set my layout to this activity
        setContentView(R.layout.activity_main);
        // initialize my FrameLayout variables here
        top = findViewById(R.id.top);
        middle = findViewById(R.id.middle);
        bottom = findViewById(R.id.bottom);

        // This is for orientation changes
        // If my savedInstanceState == null (this means I can create a new Fragment because this is a new entry into the app)
        // else (this means I did create the fragments I just need to get them back
        if (savedInstanceState == null) {
            fragTop = FlagColorFragment.newInstance(R.color.colorPrimary);
            getSupportFragmentManager().beginTransaction().add(R.id.top, fragTop, FRAG_TOP).commit();
            fragMiddle = FlagColorFragment.newInstance(R.color.colorPrimaryDark);
            getSupportFragmentManager().beginTransaction().add(R.id.middle, fragMiddle, FRAG_MIDDLE).commit();
            fragBottom = FlagColorFragment.newInstance(R.color.colorAccent);
            getSupportFragmentManager().beginTransaction().add(R.id.bottom, fragBottom, FRAG_BOTTOM).commit();
        } else {
            fragTop = (FlagColorFragment) getSupportFragmentManager().findFragmentByTag(FRAG_TOP);
            fragMiddle = (FlagColorFragment) getSupportFragmentManager().findFragmentByTag(FRAG_MIDDLE);
            fragBottom = (FlagColorFragment) getSupportFragmentManager().findFragmentByTag(FRAG_BOTTOM);
        }


        // This is a inline way for onClick (in here I handle the color changes and orientation changes)
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragTop.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.sierra_leone_top));
                fragMiddle.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.sierra_leone_middle));
                fragBottom.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.sierra_leone_bottom));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                Toast.makeText(MainActivity.this, "Sierra Leone", Toast.LENGTH_SHORT).show();
            }
        });
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragTop.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.romania_top));
                fragMiddle.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.romania_middle));
                fragBottom.changeBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.romania_bottom));
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                Toast.makeText(MainActivity.this, "Romania", Toast.LENGTH_SHORT).show();
            }
        });
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 3/7/2019 create code for 3rd country try to make it work
            }
        });
    }


}
