package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.TopArtists;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class AuctionDeserializer implements JsonDeserializer<Auction> {
    @Override
    public Auction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //The deserialisation code is missing
        JsonObject jsonObject = json.getAsJsonObject();
        Auction auction = new Auction();
        JsonObject seller = jsonObject.get("seller").getAsJsonObject();
        auction.setSeller(seller.get("login").getAsString());
        auction.setSellerRating(seller.get("rating").getAsInt());
        auction.setAuctionUrl(jsonObject.get("source").getAsJsonObject().get("url").getAsString());
        auction.setImageUrl(jsonObject.get("mainImage").getAsJsonObject().get("large").getAsString());
        auction.setTitle(jsonObject.get("name").getAsString());
        auction.setAuctionId(jsonObject.get("id").getAsLong());
        if (jsonObject.get("buyNow").getAsBoolean() == true) {
            auction.setPrice(jsonObject.get("prices").getAsJsonObject().get("buyNow").getAsString());
        }
        else {
            auction.setPrice(jsonObject.get("prices").getAsJsonObject().get("bid").getAsString());
        }
        return auction;
    }
}
