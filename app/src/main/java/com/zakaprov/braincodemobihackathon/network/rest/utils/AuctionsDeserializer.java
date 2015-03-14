package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Auctions;
import com.zakaprov.braincodemobihackathon.model.TopArtists;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class AuctionsDeserializer implements JsonDeserializer<Auctions> {

    @Override
    public Auctions deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //The deserialisation code is missing
        JsonObject jsonObject = json.getAsJsonObject();

        Auctions auctions = new Auctions();
        auctions.setAllOffersCount(jsonObject.get("count").getAsInt());
        auctions.setSearchString(jsonObject.get("searchString").getAsString());

        Auction[] auctionsTable = context.deserialize(jsonObject.get("offers"), Auction[].class);
        auctions.setAuctions(auctionsTable);
        return auctions;
    }
}
