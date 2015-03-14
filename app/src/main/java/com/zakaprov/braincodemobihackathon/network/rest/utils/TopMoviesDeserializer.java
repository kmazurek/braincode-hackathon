package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.Movie;
import com.zakaprov.braincodemobihackathon.model.TopArtists;
import com.zakaprov.braincodemobihackathon.model.TopMovies;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class TopMoviesDeserializer implements JsonDeserializer<TopMovies> {

    @Override
    public TopMovies deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {

        //The deserialisation code is missing
        JsonObject jsonObject = json.getAsJsonObject();
        final TopMovies topMovies = new TopMovies();
        Movie[] movies = context.deserialize(jsonObject.get("results"), Movie[].class);
        topMovies.setMovies(movies);
        topMovies.setResultPage(jsonObject.get("page").getAsInt());
        return topMovies;
    }
}
