package com.zakaprov.braincodemobihackathon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.adapters.MainListAdapter;

import java.util.Random;

public class MainListFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final int NUMBER_OF_COLUMNS = 2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        String[] sources = new String[15];
        Random rand = new Random();

            for (int i = 0; i < sources.length; i++)
                sources[i] = "http://www.placecage.com/c/" + (rand.nextInt(200) + 300) + "/" + (rand.nextInt(200) + 300);

        View layout = inflater.inflate(R.layout.main_list_fragment, container, false);

        mRecyclerView = (RecyclerView) layout.findViewById(R.id.mainRecyclerView);

        mLayoutManager = new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MainListAdapter(sources, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        return layout;
    }
}
