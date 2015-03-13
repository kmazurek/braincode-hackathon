package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;

import java.util.ArrayList;

public abstract class Interest
{
    private String name;
    private String imageUrl;
    private String fancyText;

    private ArrayList<Auction> auctionArrayList = new ArrayList<Auction>();

    protected abstract AllegroQuery[] getQueries();

    public void getAuctionsAsync(InterestAuctionsCallback callback)
    {
        auctionArrayList.clear();
        AllegroQuery[] queries = getQueries();

            for (AllegroQuery query : queries)
            {
                Auction[] auctions = query.getData();

                    for (Auction auction : auctions)
                        auctionArrayList.add(auction);
            }

        callback.onDownloadComplete(auctionArrayList.toArray(new Auction[0]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setFancyText(String fancyText) {
        this.fancyText = fancyText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFancyText() {
        return fancyText;
    }
}
