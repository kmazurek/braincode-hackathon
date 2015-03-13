package com.zakaprov.braincodemobihackathon.model;

public abstract class Interest
{
    private String name;
    private String imageUrl;
    private String fancyText;

    public abstract AllegroQuery[] getQueries();

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
