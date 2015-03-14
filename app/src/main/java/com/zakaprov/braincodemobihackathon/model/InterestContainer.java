package com.zakaprov.braincodemobihackathon.model;

import android.os.AsyncTask;
import android.util.Log;

import com.zakaprov.braincodemobihackathon.R;
import com.zakaprov.braincodemobihackathon.callbacks.InterestContainerCallback;
import com.zakaprov.braincodemobihackathon.model.steam.SteamGame;
import com.zakaprov.braincodemobihackathon.model.steam.SteamOwnedGames;
import com.zakaprov.braincodemobihackathon.network.rest.methods.ISteamApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.methods.LastfmApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.methods.MovieApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.providers.LastfmApiProvider;
import com.zakaprov.braincodemobihackathon.network.rest.providers.MovieApiProvider;
import com.zakaprov.braincodemobihackathon.network.rest.providers.SteamProvider;
import com.zakaprov.braincodemobihackathon.network.rest.utils.ApiUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        FetchInterestsTask task= new FetchInterestsTask(callback);
        task.execute();
    }
    public class FetchInterestsTask extends AsyncTask<Void, Void, Void> {
        public FetchInterestsTask(InterestContainerCallback callback) {
            this.callback = callback;
        }
        private InterestContainerCallback callback;
        private ArrayList<ArrayList<Interest>> interestCollections = new ArrayList<>();
        @Override
        protected Void doInBackground(Void... params) {
            LastfmApiMethods lastfmApiMethods = new LastfmApiProvider(LastfmApiMethods.class).getApiClient();
            TopArtists topArtists= lastfmApiMethods.getTopArtists(ApiUtils.LASTFM_API_USER, ApiUtils.LASTFM_API_KEY);


            ArrayList<Interest> lastFmInterests = new ArrayList<>();
            interestCollections.add(lastFmInterests);

            for (Artist artist: topArtists.getArtists()) {
                BandInterest bandInterest = new BandInterest(artist.getArtistName());
                bandInterest.setImageUrl(artist.getImageUrl());
                lastFmInterests.add(bandInterest);
            }
//            MovieApiMethods movieApiMethods = new MovieApiProvider(MovieApiMethods.class).getApiClient();
//            TopMovies topMovies= movieApiMethods.getTopMovies("1", ApiUtils.MOVIES_API_KEY);
//            for (Movie movie: topMovies.getMovies()) {
//                MovieInterest movieInterest = new MovieInterest(movie.getTitle());
//                movieInterest.setImageUrl(movie.getImageUrl());
//                interestCollection.add(movieInterest);
//            }
            ISteamApiMethods steamAPI = new SteamProvider(ISteamApiMethods.class).getApiClient();
            steamOwnedGames = steamAPI.getOwnedGames("76561198047588728", "24BBC0195657976DCC68A69122D23C23");
            List<SteamGame> steamGameList = steamOwnedGames.getResponse().getGames();
            ArrayList<Interest> steamGameInterest = new ArrayList<>();
            interestCollections.add(steamGameInterest);
            for (SteamGame sg : steamGameList) {
                GameInterest gi = new GameInterest(sg.getName());
                gi.setImageUrl(sg.getImageUrl());
                steamGameInterest.add(gi);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Collection<Interest> interests = new ArrayList<>();
            boolean isAny = true;
            while(isAny) {
                isAny = false;
                for (int i = 0; i < interestCollections.size(); i++) {
                    ArrayList<Interest> current = interestCollections.get(i);
                    if(!current.isEmpty()) {
                        isAny = true;
                        interests.add(current.get(0));
                        current.remove(0);
                    }
                }
            }

            callback.onDownloadComplete(interests.toArray(new Interest[0]));
        }
    }


}
