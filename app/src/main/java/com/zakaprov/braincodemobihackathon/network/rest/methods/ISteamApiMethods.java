package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.steam.SteamOwnedGames;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface ISteamApiMethods
{
    /*
        Sample GET request. The endpoint 'http://api.steampowered.com/' should be set in the
        appropriate RestAdapter class instance.
     */

    // GET
    @GET("IPlayerService/GetOwnedGames/v0001/?format=json")
    void getOwnedGames(@Query("steamid") String steam, @Query("key") String apiKey, Callback<SteamOwnedGames> callback);
}
