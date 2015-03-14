package com.zakaprov.braincodemobihackathon.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.zakaprov.braincodemobihackathon.CustomRecyclerView;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.adapters.AuctionListAdapter;
import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Interest;
import com.zakaprov.braincodemobihackathon.utils.PaletteTransformation;

import static android.support.v7.widget.RecyclerView.*;
import static android.support.v7.widget.RecyclerView.OnScrollListener;

public class AuctionListFragment extends AbstractFragment
{
    private CustomRecyclerView mRecyclerView;
    private Adapter mAdapter;
    private LayoutManager mLayoutManager;
    private FrameLayout mHeader;
    private FrameLayout mHeaderApla;

    private Auction[] dataSource;
    private Interest chosenInterest;
    private double headerHeight;
    private double startHeight;

    private static final int NUMBER_OF_COLUMNS = 2;
    private int bgColor;

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

        mRecyclerView = (CustomRecyclerView) layout.findViewById(R.id.mainRecyclerView);
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
        mHeaderApla = (FrameLayout) layout.findViewById(R.id.headerApla);
        headerHeight = mHeader.getLayoutParams().height;
        startHeight = headerHeight;
        ((TextView)layout.findViewById(R.id.artistName)).setText(chosenInterest.getTitle());
        final ImageView iv = (ImageView)layout.findViewById(R.id.headerImg);


        Picasso.with(getActivity()).load(chosenInterest.getImageUrl()).centerCrop().fit()
        .into(iv, new Callback() {
            @Override
            public void onSuccess() {
                try {
                    Bitmap bm = ((BitmapDrawable) (iv.getDrawable())).getBitmap();
                    Palette.generateAsync(bm, new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            bgColor = palette.getVibrantColor(Color.rgb(50, 50, 50));
                        }
                    });

                } catch(Exception e) {
                    bgColor = Color.rgb(50, 50, 50);
                }

            }

            @Override
            public void onError() {

            }
        });

        return layout;
    }

    private void onScroll(int dy) {
        double prevHeaderHeight = headerHeight;
        headerHeight = startHeight - 0.5*mRecyclerView.getVerticalOffset();

        Log.d("kulak", mRecyclerView.getVerticalOffset() + "");
        int minHeight = 200;
        if(headerHeight < minHeight) {
            headerHeight = minHeight;
        }
        if(headerHeight > startHeight) {
            headerHeight = startHeight;
        }

        double opacity = (startHeight - headerHeight) / (startHeight - minHeight);
        int opacityHex = (int)(255 * opacity);
        //Log.d(opacity);
        mHeaderApla.setBackgroundColor(Color.argb(opacityHex, Color.red(bgColor), Color.green(bgColor), Color.blue(bgColor)));

        mHeader.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)headerHeight));
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
