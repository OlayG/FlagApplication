package com.noname.flagapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FlagColorFragment extends Fragment {
    // Here is a constant used as the key for my Bundle
    public static final String BACKGROUND_COLOR = "BACKGROUND_COLOR";

    // Here i declare my variables that will be used in this fragment
    private View background;
    private int backgroundColor;

    // Empty constructor
    public FlagColorFragment() {
        // Required empty public constructor
    }

    // This is a way to create a fragment adding a default color as parameter
    public static FlagColorFragment newInstance(int defaultColor) {
        // Create a fragment variable and initialize it
        FlagColorFragment flagColorFragment = new FlagColorFragment();

        // Create a Bundle variable and initialize it
        Bundle args = new Bundle();

        // using my bundle variable to save my default color
        // Notice the key here is the constant from above
        args.putInt(BACKGROUND_COLOR, defaultColor);

        // Here I set my bundle variable to the fragment
        flagColorFragment.setArguments(args);

        // Now I return the fragment
        return flagColorFragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flag_color, container, false);
        if (savedInstanceState != null) {
            // Restore last state if saveInstanceState is not null
            backgroundColor = savedInstanceState.getInt(BACKGROUND_COLOR);
        } else {
            // if we land here saveInstanceState was null so this means we are creating a new fragment from that newInstance() Method
            // getArguments().getInt <-- this gets the bundle arguments from the newInstance() method above
            backgroundColor = getArguments().getInt(BACKGROUND_COLOR, 0);
        }

        // Here I am initializing my view from the xml
        background = view.findViewById(R.id.view_background);
        // This public method changes the background color
        changeBackgroundColor(backgroundColor);

        // return the view as we are done with the initial setup
        return view;
    }

    // I override this method so i can save the current background color in event of orientation change
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Here I use the paramater from the method to save the backgroundColor
        outState.putInt(BACKGROUND_COLOR, backgroundColor);
    }

    // This is a public method that can be accessed from the activity to change the color
    public void changeBackgroundColor(int color) {
        // Here i am setting the color to my backgroundColor variable which is scoped to this fragment
        backgroundColor = color;
        // Here is the code that actually sets the backgroundColor
        background.setBackgroundColor(backgroundColor);
    }

}
