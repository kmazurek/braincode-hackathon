package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.zakaprov.braincodemobihackathon.network.rest.methods.ISteamApiMethods;

import retrofit.RequestInterceptor;

/**
 * Created by konrad on 14.03.15.
 */
public class SteamProvider extends  AbstractApiProvider<ISteamApiMethods> {

    public SteamProvider(Class<ISteamApiMethods> apiType) {
        super(apiType);
    }

    @Override
    public RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                return;
            }
        };
    }

    @Override
    public String getEndPoint() {
        return "http://api.steampowered.com";
    }
}
