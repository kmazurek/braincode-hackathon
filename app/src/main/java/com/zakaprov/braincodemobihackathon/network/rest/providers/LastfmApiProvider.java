package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.network.rest.methods.LastfmApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.utils.ArtistDeserializer;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by kacper on 14.03.15.
 */
public class LastfmApiProvider extends AbstractApiProvider<LastfmApiMethods> {

    public LastfmApiProvider(Class<LastfmApiMethods> apiType) {
        super(apiType);
    }

    @Override
    protected String getEndPoint() {
        return "http://ws.audioscrobbler.com/";
    }

    @Override
    protected RequestInterceptor getRequestInterceptor() {
        return null;
    }

    @Override
    protected void initRestAdapter() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Artist.class, new ArtistDeserializer());
        //Add 
        final Gson gson = gsonBuilder.create();
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(this.getEndPoint())
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
