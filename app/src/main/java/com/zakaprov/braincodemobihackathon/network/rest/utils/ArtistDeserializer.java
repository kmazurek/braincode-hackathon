package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;



import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class ArtistDeserializer implements JsonDeserializer<Artist> {

    @Override
    public Artist deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        final Artist artist = new Artist();
        artist.setArtistName(jsonObject.get("name").getAsString());
        artist.setPlaycount(jsonObject.get("playcount").getAsInt());
        JsonArray imageArray = jsonObject.getAsJsonArray("image");
        JsonObject largeImageData = imageArray.get(4).getAsJsonObject();
        artist.setImageUrl(largeImageData.get("#text").getAsString());
        return artist;
    }
}
