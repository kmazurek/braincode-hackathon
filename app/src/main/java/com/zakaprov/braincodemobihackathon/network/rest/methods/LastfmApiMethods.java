package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.TopArtists;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kacper on 13.03.15.
 */
public interface LastfmApiMethods {


    @GET("/2.0/?method=user.gettopartists&format=json")
    TopArtists getTopArtists(@Query("user") String userName, @Query("api_key") String apiKey);
}
