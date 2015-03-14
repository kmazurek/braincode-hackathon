package com.zakaprov.braincodemobihackathon.model;

import android.util.Log;

import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.callbacks.InterestContainerCallback;
import com.zakaprov.braincodemobihackathon.model.steam.SteamGame;
import com.zakaprov.braincodemobihackathon.model.steam.SteamOwnedGames;
import com.zakaprov.braincodemobihackathon.network.rest.methods.ISteamApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.providers.SteamProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class InterestContainer
{
    private Interest[] interests;
    private SteamOwnedGames steamOwnedGames;

    public InterestContainer() {
        interests = new Interest[9];
        interests[0] = new GameInterest("Half Life 3");
        interests[1] = new GameInterest("Assassins Creed");
        interests[2] = new GameInterest("League of Legends");

        interests[3] = new BandInterest("Metallica");
        interests[4] = new BandInterest("Red Hot Chilli Peppers");
        interests[5] = new BandInterest("Iron Maiden");

        interests[6] = new BookInterest("50 Shades of Grey");
        interests[7] = new BookInterest("Lord of The Rings");

        interests[8] = new MovieInterest("Interstellar");
    }

    public void getInterestsAsync(final InterestContainerCallback callback)
    {
        final Collection<Interest> interestCollection = new ArrayList<>();
        // TODO
        ISteamApiMethods steamAPI = new SteamProvider(ISteamApiMethods.class).getApiClient();
        steamAPI.getOwnedGames("76561198047588728", "24BBC0195657976DCC68A69122D23C23", new Callback<SteamOwnedGames>() {
            @Override
            public void success(SteamOwnedGames steamOwnedGamesResult, Response response) {
                steamOwnedGames = steamOwnedGamesResult;
                List<SteamGame> steamGameList = steamOwnedGames.getResponse().getGames();
                for (SteamGame sg : steamGameList) {
                    GameInterest gi = new GameInterest(sg.getName());
//            gi.setImageUrl(sg.getImageUrl());
                    gi.setImageUrl(R.drawable.iron_maiden);
                    Log.i("IMG", sg.getImageUrl());
                    interestCollection.add(gi);
                }

                callback.onDownloadComplete(interestCollection.toArray(new Interest[0]));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("games", "ERROR.");
            }
        });

    }
}
