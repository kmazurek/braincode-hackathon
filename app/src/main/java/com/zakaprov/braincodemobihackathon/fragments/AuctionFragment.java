package com.zakaprov.braincodemobihackathon.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        String text = "NASZYWKA GRUBA, WYSZYWANA JAK NA ZDJĘCIU!<br/><br/>"+
                "            Wielkość - PATRZ FOTKA<br/><br/><br/>"+
                "<b>UWAGA! ZASTRZEGAM MOŻLIWOŚĆ CHWILOWEGO BRAKU LUB WYSYŁKI W INNYM KOLORZE!</b><br/><br/><br/>"+
                "5 zł polecony ekonomiczny<br/>" +
                "6 zł polecony priorytet<br/><br/>" +
                "Płatność PayU = szybka wysyłka !<br/><br/><br/><br/><br/>" +
                "----------<br/>" +
                "Dodano 2014-07-23 10:42<br/>" +
                "W PRZYPADKU NASZYWEK WYSZYWANYCH CZĘSTO ZDARZAJĄ SIĘ BRAKI, ABY UNIKNĄĆ NIEPOROZUMIEŃ PROSZĘ O KONTAKT W SPRAWIE DOSTĘPNOŚCI, PODAWANIE ALTERNATYWY LUB WYROZUMIAŁOŚĆ.";

        ((TextView)layout.findViewById(R.id.auctionText)).setText(Html.fromHtml(text));

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
