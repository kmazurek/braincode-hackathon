package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.network.rest.NetworkCallback;

public class AllegroQuery
{
    public String queryString;
    public String allegroCategory;
    public String readableCategory;

    private void getData(NetworkCallback<Auction[]> callback)
    {

    }

    public AllegroQuery(String queryString, String allegroCategory, String readableCategory) {
        this.queryString = queryString;
        this.allegroCategory = allegroCategory;
        this.readableCategory = readableCategory;
    }
}