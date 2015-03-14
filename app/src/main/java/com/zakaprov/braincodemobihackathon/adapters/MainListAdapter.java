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
import com.zakaprov.braincodemobihackathon.model.Interest;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>
{
    private Interest[] mDataset;
    private MainActivity mMainActivity;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTextViewTitle;
        public TextView mTextViewFancy;
        public ImageView mImageView;

        public Interest interest;

        public ViewHolder(View card) {
            super(card);
            mTextViewTitle = (TextView) card.findViewById(R.id.txtTitle);
            mTextViewFancy = (TextView) card.findViewById(R.id.txtFancy);
            mImageView = (ImageView) card.findViewById(R.id.imgCard);

            card.setOnClickListener(this);
        }

        public void onClick(View v) {
            MainListAdapter.this.mMainActivity.onChooseInterest(this.interest);
        }

    }

    public MainListAdapter(Interest[] myDataset, MainActivity context) {
        mDataset = myDataset;
        mMainActivity = context;
    }

    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Interest currentInterest = mDataset[position];
        holder.interest = currentInterest;

        holder.mTextViewTitle.setText(currentInterest.getTitle());
        holder.mTextViewFancy.setText(currentInterest.getFancyText());
        Picasso.with(mMainActivity).load(currentInterest.getImageUrl()).centerCrop().fit().into(holder.mImageView);
    }

    private int getImageUrl(String title)
    {
        switch (title)
        {
            case "Half Life 3":
                return R.drawable.half_life_3;
            case "Assassins Creed":
                return R.drawable.assassins_creed;
            case "League of Legends":
                return R.drawable.league_of_legends;
            case "Metallica":
                return R.drawable.metallica;
            case "Red Hot Chilli Peppers":
                return R.drawable.red_hot_chili_peppers;
            case "Iron Maiden":
                return R.drawable.iron_maiden;
            case "Interstellar":
                return R.drawable.interstellar;
            case "Lord of The Rings":
                return R.drawable.lord_of_the_rings;
            default:
                return R.drawable.half_life_3;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}