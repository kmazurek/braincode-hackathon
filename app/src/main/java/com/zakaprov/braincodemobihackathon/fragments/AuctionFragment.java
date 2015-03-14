package com.zakaprov.braincodemobihackathon.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.melnykov.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.callbacks.OfferCallback;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Offer;
import com.zakaprov.braincodemobihackathon.network.rest.methods.IAllegroApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.providers.AllegroApiProvider;

public class AuctionFragment extends AbstractFragment implements View.OnClickListener
{

    private Auction auction;
    private ImageView imageView;
    private TextView headerTextView;

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
        final TextView ourTextView = (TextView) layout.findViewById(R.id.auctionText);
        imageView = (ImageView) layout.findViewById(R.id.headerImg);
        headerTextView = (TextView) layout.findViewById(R.id.headerTextView);
        TextView priceText = (TextView) layout.findViewById(R.id.price);
        TextView sellerText = (TextView) layout.findViewById(R.id.shop);
        priceText.setText(auction.getPrice());
        headerTextView.setText(auction.getTitle());
        sellerText.setText(auction.getSeller());

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

        new FetchAuctionDescription(this.auction, new OfferCallback() {
            @Override
            public void onDownloadComplete(Offer result) {
                ourTextView.setText(result.getHtmlDescription());
            }
        }).execute();
//        ((TextView)layout.findViewById(R.id.auctionText)).setText(Html.fromHtml(text));



        return layout;
    }

    public void setChosenAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public void onClick(View v) {
        String url = auction.getAuctionUrl();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public class FetchAuctionDescription extends AsyncTask<Void, Void, Void> {
        public FetchAuctionDescription(Auction auctionToFetch, OfferCallback callback) {
            this.auction = auctionToFetch;
            this.callback = callback;
        }
        private OfferCallback callback;
        private Auction auction;
        private Offer offer;

        @Override
        protected Void doInBackground(Void... params) {

            IAllegroApiMethods allegrofmApiMethods = new AllegroApiProvider(IAllegroApiMethods.class).getApiClient();
            offer= allegrofmApiMethods.getOffer(auction.getAuctionId());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.d("KH", offer.getHtmlDescription());
            callback.onDownloadComplete(offer);
            Picasso.with(getActivity()).load(auction.getImageUrl()).centerCrop().fit().into(imageView);
        }
    }
}
