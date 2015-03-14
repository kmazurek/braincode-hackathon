package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zakaprov.braincodemobihackathon.model.Artist;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Auctions;
import com.zakaprov.braincodemobihackathon.model.TopArtists;
import com.zakaprov.braincodemobihackathon.network.rest.methods.IAllegroApiMethods;
import com.zakaprov.braincodemobihackathon.network.rest.utils.ArtistDeserializer;
import com.zakaprov.braincodemobihackathon.network.rest.utils.AuctionDeserializer;
import com.zakaprov.braincodemobihackathon.network.rest.utils.AuctionsDeserializer;
import com.zakaprov.braincodemobihackathon.network.rest.utils.TopArtistDeserializer;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class AllegroApiProvider extends AbstractApiProvider<IAllegroApiMethods>
{
    public static String ALLEGRO_API_TOKEN;

    public AllegroApiProvider(Class<IAllegroApiMethods> apiType) {
        super(apiType);
    }

    @Override
    protected String getEndPoint() {
        return "https://api.natelefon.pl/";
    }

    @Override
    protected RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addQueryParam("access_token", ALLEGRO_API_TOKEN);
            }
        };
    }

    @Override
    protected void initRestAdapter() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Auction.class, new AuctionDeserializer());
        gsonBuilder.registerTypeAdapter(Auctions.class, new AuctionsDeserializer());
        final Gson gson = gsonBuilder.create();
        this.restAdapter = new RestAdapter.Builder()
                .setEndpoint(this.getEndPoint())
                .setConverter(new GsonConverter(gson))
                .build();
    }
}
