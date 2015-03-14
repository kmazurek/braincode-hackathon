package com.zakaprov.braincodemobihackathon.network.rest.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.Movie;

import java.lang.reflect.Type;

/**
 * Created by kacper on 14.03.15.
 */
public class MovieDeserializer implements JsonDeserializer<Movie> {

    @Override
    public Movie deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();
        final Movie movie = new Movie();
        movie.setTitle(jsonObject.get("title").getAsString());
        movie.setVoteAverage(jsonObject.get("vote_average").getAsDouble());
        String imageUrl = "http://image.tmdb.org/t/p/w500/";
        imageUrl += jsonObject.get("poster_path").getAsString();
        movie.setImageUrl(imageUrl);
        return movie;
    }
}