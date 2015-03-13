package com.zakaprov.braincodemobihackathon.model;

public class AllegroQuery
{
    public String queryString;
    public String allegroCategory;
    public String readableCategory;

    public Auction[] getData()
    {
        // TODO synchronously download data
        return null;
    }

    public AllegroQuery(String queryString, String allegroCategory, String readableCategory) {
        this.queryString = queryString;
        this.allegroCategory = allegroCategory;
        this.readableCategory = readableCategory;
    }
}