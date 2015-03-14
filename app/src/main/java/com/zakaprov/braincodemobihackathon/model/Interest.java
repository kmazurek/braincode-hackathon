package com.zakaprov.braincodemobihackathon.model;

import android.os.AsyncTask;
import android.util.Log;

import com.zakaprov.braincodemobihackathon.callbacks.InterestAuctionsCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Interest
{
    protected String title;
    private String imageUrl;
    private String fancyText;
    protected Map<String, String> categories;   // catID : readable

    protected static String[] fancyStrings = {"Look for characters from", "Don't you have enough",
                                            "Get some gadgets from", "Check what's available for"};

    public Interest()
    {
        categories = new HashMap<>();
    }

    public Interest(String title) {
        this();
        this.title = title;
    }

    protected void generateFancyText()
    {
        int idx = new Random().nextInt(fancyStrings.length);
        String random = (fancyStrings[idx]);
        this.setFancyText(random);
    }

    public Map<String, String> getCategories()
    {
        return categories;
    }

    public void setCategories(Map<String, String> categories)
    {
        this.categories = categories;
    }

    public static String[] getFancyStrings()
    {
        return fancyStrings;
    }

    public static void setFancyStrings(String[] fancyStrings)
    {
        Interest.fancyStrings = fancyStrings;
    }

    public ArrayList<Auction> getAuctionArrayList()
    {
        return auctionArrayList;
    }

    public void setAuctionArrayList(ArrayList<Auction> auctionArrayList)
    {
        this.auctionArrayList = auctionArrayList;
    }

    private ArrayList<Auction> auctionArrayList = new ArrayList<Auction>();

    protected AllegroQuery[] getQueries() {
        List<AllegroQuery> tab = new ArrayList<>();
        for (Map.Entry<String, String> e : categories.entrySet()) {
            tab.add(new AllegroQuery(title, e.getKey(), e.getValue()));
        }
        return tab.toArray(new AllegroQuery[0]);
    }

    public void getAuctionsAsync(InterestAuctionsCallback callback)
    {
        new FetchAuctionsTask(callback).execute();
    }

    public class FetchAuctionsTask extends AsyncTask<Void, Void, Void>
    {
        public FetchAuctionsTask(InterestAuctionsCallback callback) {
            this.callback = callback;
        }
        private InterestAuctionsCallback callback;

        @Override
        protected Void doInBackground(Void... params) {

            auctionArrayList.clear();
            AllegroQuery[] queries = getQueries();

            for (AllegroQuery query : queries)
            {
                Auction[] auctions = query.getData();

                for (Auction auction : auctions)
                    auctionArrayList.add(auction);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Auction[] auctions = auctionArrayList.toArray(new Auction[0]);

                for (Auction a : auctions)
                    Log.d("KEK", a.toString());

            callback.onDownloadComplete(auctions);
        }
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
