package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by kacper on 13.03.15.
 */
public class Artist {

    private String artistName;
    private int playcount;
    private String imageUrl;


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
