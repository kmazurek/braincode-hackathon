package com.zakaprov.braincodemobihackathon.network.rest.methods;

import com.zakaprov.braincodemobihackathon.model.TopMovies;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by kacper on 14.03.15.
 */
public interface MovieApiMethods {
    @GET("/3/movie/popular?language=en&include_image_language=en,null")
    TopMovies getTopMovies(@Query("page") String pageNumber, @Query("api_key") String apiKey);
}
