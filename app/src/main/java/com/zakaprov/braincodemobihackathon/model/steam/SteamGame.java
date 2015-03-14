package com.zakaprov.braincodemobihackathon.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by konrad on 14.03.15.
 */

/*
appid Unique identifier for the game
name The name of the game
playtime_2weeks The total number of minutes played in the last 2 weeks
playtime_forever The total number of minutes played "on record", since Steam began tracking total playtime in early 2009.
img_icon_url, img_logo_url - these are the filenames of various images for the game. To construct the URL to the image, use this format: http://media.steampowered.com/steamcommunity/public/images/apps/{appid}/{hash}.jpg. For example, the TF2 logo is returned as "07385eb55b5ba974aebbe74d3c99626bda7920b8", which maps to the URL: [1]
has_community_visible_stats indicates there is a stats page with achievements or other game stats available for this game. The uniform URL for accessing this data is http://steamcommunity.com/profiles/{steamid}/stats/{appid}. For example, Robin's TF2 stats can be found at: http://steamcommunity.com/profiles/76561197960435530/stats/440. You may notice that clicking this link will actually redirect to a vanity URL like /id/robinwalker/stats/TF2
 */
public class SteamGame {

    @Expose
    private Integer appid;
    @Expose
    private String name;
    @SerializedName("playtime_forever")
    @Expose
    private Integer playtimeForever;
    @SerializedName("img_icon_url")
    @Expose
    private String imgIconUrl;
    @SerializedName("img_logo_url")
    @Expose
    private String imgLogoUrl;
    @SerializedName("has_community_visible_stats")
    @Expose
    private Boolean hasCommunityVisibleStats;
    @SerializedName("playtime_2weeks")
    @Expose
    private Integer playtime2weeks;

    /**
     *
     * @return
     * The appid
     */
    public Integer getAppid() {
        return appid;
    }

    /**
     *
     * @param appid
     * The appid
     */
    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The playtimeForever
     */
    public Integer getPlaytimeForever() {
        return playtimeForever;
    }

    /**
     *
     * @param playtimeForever
     * The playtime_forever
     */
    public void setPlaytimeForever(Integer playtimeForever) {
        this.playtimeForever = playtimeForever;
    }

    /**
     *
     * @return
     * The imgIconUrl
     */
    public String getImgIconUrl() {
        return imgIconUrl;
    }

    /**
     *
     * @param imgIconUrl
     * The img_icon_url
     */
    public void setImgIconUrl(String imgIconUrl) {
        this.imgIconUrl = imgIconUrl;
    }

    /**
     *
     * @return
     * The imgLogoUrl
     */
    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    /**
     *
     * @param imgLogoUrl
     * The img_logo_url
     */
    public void setImgLogoUrl(String imgLogoUrl) {
        this.imgLogoUrl = imgLogoUrl;
    }

    /**
     *
     * @return
     * The hasCommunityVisibleStats
     */
    public Boolean getHasCommunityVisibleStats() {
        return hasCommunityVisibleStats;
    }

    /**
     *
     * @param hasCommunityVisibleStats
     * The has_community_visible_stats
     */
    public void setHasCommunityVisibleStats(Boolean hasCommunityVisibleStats) {
        this.hasCommunityVisibleStats = hasCommunityVisibleStats;
    }

    /**
     *
     * @return
     * The playtime2weeks
     */
    public Integer getPlaytime2weeks() {
        return playtime2weeks;
    }

    /**
     *
     * @param playtime2weeks
     * The playtime_2weeks
     */
    public void setPlaytime2weeks(Integer playtime2weeks) {
        this.playtime2weeks = playtime2weeks;
    }

    public String getImageUrl() {
        return "http://cdn.akamai.steamstatic.com/steam/apps/" + appid + "/header.jpg";
    }

}
