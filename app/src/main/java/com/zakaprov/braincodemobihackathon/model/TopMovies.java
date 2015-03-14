package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by kacper on 14.03.15.
 */
public class TopMovies {

    private int resultPage;
    private Movie[] movies;

    public int getResultPage() {
        return resultPage;
    }

    public void setResultPage(int resultPage) {
        this.resultPage = resultPage;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }
}
