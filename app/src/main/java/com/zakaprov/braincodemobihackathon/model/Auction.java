package com.zakaprov.braincodemobihackathon.model;

public class Auction
{
    private String title;
    private String imageUrl;
    private String auctionUrl;
    private String seller;
    private int sellerRating;
    private String price;
    private long auctionId;

    @Override
    public String toString()
    {
        return title + " " + imageUrl + " " + price;
    }

    public long getAuctionId() {
        return auctionId;
    }
    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

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
    public String getAuctionUrl() {
        return auctionUrl;
    }
    public void setAuctionUrl(String auctionUrl) {
        this.auctionUrl = auctionUrl;
    }
    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public int getSellerRating() {
        return sellerRating;
    }
    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
