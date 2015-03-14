package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.TopArtists;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class TopArtistDeserializer implements JsonDeserializer<TopArtists> {

    @Override
    public TopArtists deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        //The deserialisation code is missing
        JsonObject jsonObject = json.getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("topartists");
        final TopArtists topArtists = new TopArtists();
        Artist[] artists = context.deserialize(jsonObject.get("artist"), Artist[].class);
        topArtists.setArtist(artists);
        return topArtists;
    }
}