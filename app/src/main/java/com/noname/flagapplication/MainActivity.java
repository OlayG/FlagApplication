package com.noname.flagapplication;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String FRAG_TOP = "FRAG_TOP";
    public static final String FRAG_MIDDLE = "FRAG_MIDDLE";
    public static final String FRAG_BOTTOM = "FRAG_BOTTOM";

    FrameLayout top, middle, bottom;
    FlagColorFragment fragTop, fragMiddle, fragBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top = findViewById(R.id.top);
        middle = findViewById(R.id.middle);
        bottom = findViewById(R.id.bottom);

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

            }
        });
    }


}
