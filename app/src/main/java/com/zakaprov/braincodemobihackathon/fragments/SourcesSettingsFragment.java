package com.zakaprov.braincodemobihackathon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;

/**
 * Created by kulak on 14/03/15.
 */
public class SourcesSettingsFragment extends AbstractFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MainActivity activity = (MainActivity) getActivity();


        View layout = inflater.inflate(R.layout.sources_settings_fragment, container, false);

        FloatingActionButton fab = (FloatingActionButton)layout.findViewById(R.id.fab);
        fab.show();

        return layout;
    }
}
