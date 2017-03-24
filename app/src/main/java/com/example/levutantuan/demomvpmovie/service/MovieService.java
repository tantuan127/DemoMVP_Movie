package com.example.levutantuan.demomvpmovie.service;

import com.example.levutantuan.demomvpmovie.data.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("movie/now_playing")
    Call<MoviesResponse> getNowPlayingMovies(@Query("api_key") String apiKey, @Query("page") int
        page);
    @GET("search/movie")
    Call<MoviesResponse> searchMovie(@Query("api_key") String apiKey, @Query("query") String
        query, @Query("page") int page);
}
