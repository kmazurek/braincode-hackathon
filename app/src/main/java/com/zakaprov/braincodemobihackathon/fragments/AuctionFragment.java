package com.zakaprov.braincodemobihackathon.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.adapters.AuctionListAdapter;
import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Interest;

public class AuctionFragment extends AbstractFragment implements View.OnClickListener
{

    private Auction auction;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MainActivity activity = (MainActivity) getActivity();


        View layout = inflater.inflate(R.layout.single_auction_fragment, container, false);

        FloatingActionButton fab = (FloatingActionButton)layout.findViewById(R.id.fab);
        fab.show();
        fab.setOnClickListener(this);

        return layout;
    }

    public void setChosenAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public void onClick(View v) {
        String url = "http://allegro.pl/red-hot-chilli-peppers-naszywka-wyszywana-i5104119855.html";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
