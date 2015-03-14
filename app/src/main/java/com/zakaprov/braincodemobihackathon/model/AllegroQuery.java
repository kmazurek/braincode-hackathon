package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.network.rest.methods.IAllegroApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.providers.AllegroApiProvider;

public class AllegroQuery
{
    private String queryString;
    private String allegroCategory;
    private String readableCategory;

    public Auction[] getData()
    {
        AllegroApiProvider provider = new AllegroApiProvider(IAllegroApiMethods.class);
        Auction[] auctions = provider.getApiClient().getAuctions(AllegroQuery.this).getAuctions();

        return auctions;
    }

    public String getQueryString()
    {
        return queryString;
    }

    public void setQueryString(String queryString)
    {
        this.queryString = queryString;
    }

    public String getAllegroCategory()
    {
        return allegroCategory;
    }

    public void setAllegroCategory(String allegroCategory)
    {
        this.allegroCategory = allegroCategory;
    }

    public String getReadableCategory()
    {
        return readableCategory;
    }

    public void setReadableCategory(String readableCategory)
    {
        this.readableCategory = readableCategory;
    }

    public AllegroQuery(String queryString, String allegroCategory, String readableCategory) {
        this.queryString = queryString;
        this.allegroCategory = allegroCategory;
        this.readableCategory = readableCategory;
    }
}