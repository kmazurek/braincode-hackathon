package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.steam.SteamOwnedGames;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kacper on 13.03.15.
 */
public interface LastfmApiMethods {


    @GET("2.0/?method=user.gettopartists&user=rj&api_key=416a255d48a1fa9d747490a6c8fad10a&format=json")
    List<Artist> getTopArtists(@Query("user") String userName, @Query("api_key") String apiKey);
}
