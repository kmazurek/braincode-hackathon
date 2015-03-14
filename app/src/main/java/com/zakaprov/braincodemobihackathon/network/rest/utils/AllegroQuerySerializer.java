package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.zakaprov.braincodemobihackathon.model.AllegroQuery;

import java.lang.reflect.Type;

public class AllegroQuerySerializer implements JsonSerializer<AllegroQuery>
{
    private static final int LIMIT = 50;

    @Override
    public JsonElement serialize(AllegroQuery query, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject object = new JsonObject();
        object.addProperty("limit", LIMIT);
        object.addProperty("searchString", query.getQueryString());
        object.addProperty("category", query.getAllegroCategory());
        return object;
    }
}
