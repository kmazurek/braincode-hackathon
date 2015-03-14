package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.zakaprov.braincodemobihackathon.network.rest.methods.ISteamApiMethods;

import retrofit.RequestInterceptor;

/**
 * Created by konrad on 14.03.15.
 */
public class SteamProvider extends  AbstractApiProvider<ISteamApiMethods> {

    protected SteamProvider(Class<ISteamApiMethods> apiType) {
        super(apiType);
    }

    @Override
    protected RequestInterceptor getRequestInterceptor() {
        return null;
    }

    @Override
    protected String getEndPoint() {
        return "http://api.steampowered.com";
    }
}
