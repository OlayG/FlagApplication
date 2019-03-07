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
    public static final String BACKGROUND_COLOR = "backgroundColor";
    private View background;
    private int backgroundColor;

    public FlagColorFragment() {
        // Required empty public constructor
    }

    public static FlagColorFragment newInstance(int color) {
        FlagColorFragment flagColorFragment = new FlagColorFragment();
        Bundle args = new Bundle();
        args.putInt(BACKGROUND_COLOR, color);
        flagColorFragment.setArguments(args);
        return flagColorFragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flag_color, container, false);
        if (savedInstanceState != null) {
            // Restore last state
            backgroundColor = savedInstanceState.getInt(BACKGROUND_COLOR);
        } else {
            backgroundColor = getArguments().getInt(BACKGROUND_COLOR, 0);
        }

        background = view.findViewById(R.id.view_background);
        changeBackgroundColor(backgroundColor);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BACKGROUND_COLOR, backgroundColor);
    }

    public void changeBackgroundColor(int color) {
        backgroundColor = color;
        background.setBackgroundColor(backgroundColor);
    }

}
