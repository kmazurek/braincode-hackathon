package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;

import java.util.ArrayList;
import java.util.Random;

public abstract class Interest
{
    protected String title;
    private String imageUrl;
    private String fancyText;
    protected String[] categories;

    private static String[] fancyStrings = {"Look for characters from", "Don't you have enough",
                                            "Get some gadgets from", "Check what's available for"};

    public Interest()
    {

    }

    public Interest(String title) {
        this.title = title;
        int idx = new Random().nextInt(fancyStrings.length);
        String random = (fancyStrings[idx]);
        this.setFancyText(random);
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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
