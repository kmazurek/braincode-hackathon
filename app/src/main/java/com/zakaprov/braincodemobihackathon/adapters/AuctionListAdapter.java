package com.zakaprov.braincodemobihackathon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zakaprov.braincodemobihackathon.MainActivity;
import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.model.Auction;

public class AuctionListAdapter extends RecyclerView.Adapter<AuctionListAdapter.ViewHolder>
{
    private Auction[] mDataset;
    private MainActivity mMainActivity;

    private static final int[] MOCKUP_IDS = {
            R.drawable.rhcp_1,
            R.drawable.rhcp_2,
            R.drawable.rhcp_3,
            R.drawable.rhcp_4,
            R.drawable.rhcp_5,
            R.drawable.rhcp_6,
            R.drawable.rhcp_7,
            R.drawable.rhcp_8
    };

    private static final String[] MOCKUP_TITLES = {
            "Red Hot Chilli Peppers - By The Way L BLACK",
            "Red Hot Chilli Peppers - Live At Slane Castle DVD",
            "GUWNO",
            "Red Hot Chilli Peppers - DVD OFF THE MAP Folia!",
            "RHCP T-shirt Flea M - nowa!",
            "Red Hot Chilli Peppers Koszulka Biała",
            "Red Hot Chilli Peppers Suck My Kiss Czerwona L",
            "RHCP koszulka damska M"
    };

    private static final String[] MOCKUP_PRICES = {
            "75,00 PLN",
            "29,00 PLN",
            "66,66 PLN",
            "34,50 PLN",
            "62,00 PLN",
            "59,99 PLN",
            "45,90 PLN",
            "65,50 PLN"
    };

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextView;
        public ImageView mImageView;

        public Auction auction;

        public ViewHolder(View card) {
            super(card);
            mTextView = (TextView) card.findViewById(R.id.txtFancy);
            mImageView = (ImageView) card.findViewById(R.id.imgCard);

            card.setOnClickListener(this);
        }

        public void onClick(View v) {
            AuctionListAdapter.this.mMainActivity.onChooseAuction(this.auction);
        }
    }

    public AuctionListAdapter(Auction[] myDataset, MainActivity context) {
        mDataset = myDataset;

        // MOCKUP
        mDataset = generateMockupAuctions();

        mMainActivity = context;
    }

    @Override
    public AuctionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Auction currentAuction = mDataset[position];

        holder.auction = currentAuction;

        holder.mTextView.setText(currentAuction.getTitle());
        Picasso.with(mMainActivity).load(MOCKUP_IDS[position]).centerCrop().fit().into(holder.mImageView);
    }

    private Auction[] generateMockupAuctions()
    {
        Auction[] auctions = new Auction[MOCKUP_IDS.length];

            for (int i = 0; i < auctions.length; i++)
            {
                Auction auction = new Auction();
                auction.setTitle(MOCKUP_TITLES[i]);
                auction.setPrice(MOCKUP_PRICES[i]);

                auctions[i] = auction;
            }

        return auctions;
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}