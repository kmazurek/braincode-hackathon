package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.Auctions;
import com.zakaprov.braincodemobihackathon.model.Interest;
import com.zakaprov.braincodemobihackathon.model.Token;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface IAllegroApiMethods
{
    @POST("/v2/allegro/offers")
    Auctions getAuctions(@Body Interest body, @Query("category") String category, @Query("searchString") String queryString);

    @GET("/v1/oauth/token?grant_type=client_credentials")
    @Headers("Authorization: Basic YnJhaW5jb2RlLm1vYmkuMjAxNTpzbUFhbWN6cA==")
    Token getAccessToken();
}
