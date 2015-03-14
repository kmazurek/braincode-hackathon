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
        mMainActivity = context;
    }

    @Override
    public AuctionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
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
        Picasso.with(mMainActivity).load(currentAuction.getImageUrl()).centerCrop().fit().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}