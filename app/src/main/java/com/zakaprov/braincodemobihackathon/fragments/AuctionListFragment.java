package com.zakaprov.braincodemobihackathon.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.adapters.AuctionListAdapter;
import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Interest;

public class AuctionListFragment extends Fragment
{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Auction[] dataSource;

    private static final int NUMBER_OF_COLUMNS = 2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MainActivity activity = (MainActivity) getActivity();
        Interest chosenInterest = activity.getChosenInterest();

        chosenInterest.getAuctionsAsync(new AuctionListCallback());

        View layout = inflater.inflate(R.layout.auction_list_fragment, container, false);

        mRecyclerView = (RecyclerView) layout.findViewById(R.id.mainRecyclerView);

        mLayoutManager = new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return layout;
    }

    private class AuctionListCallback implements InterestAuctionsCallback
    {
        @Override
        public void onDownloadComplete(Auction[] result)
        {
            dataSource = result;

            mAdapter = new AuctionListAdapter(dataSource, getActivity());
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}