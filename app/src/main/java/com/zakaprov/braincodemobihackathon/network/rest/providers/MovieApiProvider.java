package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zakaprov.braincodemobihackathon.model.Movie;
import com.zakaprov.braincodemobihackathon.model.TopMovies;
import com.zakaprov.braincodemobihackathon.network.rest.methods.MovieApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.utils.MovieDeserializer;
import com.zakaprov.braincodemobihackathon.network.rest.utils.TopMoviesDeserializer;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by kacper on 14.03.15.
 */
public class MovieApiProvider extends AbstractApiProvider<MovieApiMethods> {

    public MovieApiProvider(Class<MovieApiMethods> apiType) {
        super(apiType);
    }
    @Override
    protected String getEndPoint() {
        return "https://api.themoviedb.org";
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
        gsonBuilder.registerTypeAdapter(Movie.class, new MovieDeserializer());
        gsonBuilder.registerTypeAdapter(TopMovies.class, new TopMoviesDeserializer());
        final Gson gson = gsonBuilder.create();
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(this.getEndPoint())
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
