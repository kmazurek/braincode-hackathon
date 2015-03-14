package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.TopArtists;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kacper on 13.03.15.
 */
public interface LastfmApiMethods {


    @GET("2.0/?method=user.gettopartists&user=rj&api_key=416a255d48a1fa9d747490a6c8fad10a&format=json")
    TopArtists getTopArtists(@Query("user") String userName, @Query("api_key") String apiKey);
}
