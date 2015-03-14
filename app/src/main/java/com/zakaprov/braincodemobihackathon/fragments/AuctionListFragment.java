package com.zakaprov.braincodemobihackathon.fragments;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.adapters.AuctionListAdapter;
import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Interest;

import static android.support.v7.widget.RecyclerView.*;
import static android.support.v7.widget.RecyclerView.OnScrollListener;

public class AuctionListFragment extends AbstractFragment
{
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private FrameLayout mHeader;

    private Auction[] dataSource;
    private Interest chosenInterest;

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

        // MOCKUP
//        chosenInterest.getAuctionsAsync(new AuctionListCallback());

        View layout = inflater.inflate(R.layout.auction_list_fragment, container, false);

        mRecyclerView = (RecyclerView) layout.findViewById(R.id.mainRecyclerView);
        mRecyclerView.setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                onScroll(dy);
            }
        });

        mLayoutManager = new GridLayoutManager(getActivity(), NUMBER_OF_COLUMNS);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // MOCKUP
        mAdapter = new AuctionListAdapter(dataSource, (MainActivity)getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mHeader = (FrameLayout) layout.findViewById(R.id.header);
        ImageView iv = (ImageView)layout.findViewById(R.id.headerImg);


        Picasso.with(getActivity()).load(chosenInterest.getImageUrl()).centerCrop().fit().into(iv);

        return layout;
    }

    private void onScroll(int dy) {
        Log.d("kulak", dy + "");
    }

    public void setChosenInterest(Interest interest)
    {
        chosenInterest = interest;
    }

    private class AuctionListCallback implements InterestAuctionsCallback
    {
        @Override
        public void onDownloadComplete(Auction[] result)
        {
            dataSource = result;

            mAdapter = new AuctionListAdapter(dataSource, (MainActivity)getActivity());
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
