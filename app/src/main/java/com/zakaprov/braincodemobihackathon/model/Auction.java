package com.zakaprov.braincodemobihackathon.model;

public class Auction
{
    private String title;
    private String imageUrl;
    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }
}
