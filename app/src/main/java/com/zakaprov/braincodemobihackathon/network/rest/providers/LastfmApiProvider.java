package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.TopArtists;
import com.zakaprov.braincodemobihackathon.network.rest.methods.LastfmApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.utils.ArtistDeserializer;
import com.zakaprov.braincodemobihackathon.network.rest.utils.TopArtistDeserializer;

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
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
            }
        };
    }

    @Override
    protected void initRestAdapter() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Artist.class, new ArtistDeserializer());
        gsonBuilder.registerTypeAdapter(TopArtists.class, new TopArtistDeserializer());
        final Gson gson = gsonBuilder.create();
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(this.getEndPoint())
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
