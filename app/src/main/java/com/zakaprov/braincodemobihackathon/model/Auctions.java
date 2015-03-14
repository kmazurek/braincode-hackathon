package com.zakaprov.braincodemobihackathon.model;

public class Auctions
{
    private String searchString;
    private int allOffersCount;
    private Auction[] auctions;


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public int getAllOffersCount() {
        return allOffersCount;
    }

    public void setAllOffersCount(int allOffersCount) {
        this.allOffersCount = allOffersCount;
    }

    public Auction[] getAuctions() {
        return auctions;
    }

    public void setAuctions(Auction[] auctions) {
        this.auctions = auctions;
    }
}
