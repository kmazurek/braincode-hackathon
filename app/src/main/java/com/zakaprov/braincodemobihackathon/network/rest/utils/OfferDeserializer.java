package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Offer;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class OfferDeserializer implements JsonDeserializer<Offer> {
    @Override
    public Offer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject rootObject = json.getAsJsonObject();
        Offer offer = new Offer();
        offer.setHtmlDescription(rootObject.get("description").getAsJsonObject().get("plainText").getAsString());

        return offer;
    }
}
