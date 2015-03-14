package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.zakaprov.braincodemobihackathon.model.Interest;

import java.lang.reflect.Type;

public class InterestSerializer implements JsonSerializer<Interest>
{
    @Override
    public JsonElement serialize(Interest interest, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject object = new JsonObject();
        return object;
    }
}
