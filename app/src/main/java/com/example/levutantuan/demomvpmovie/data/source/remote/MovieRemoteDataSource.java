package com.example.levutantuan.demomvpmovie.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.levutantuan.demomvpmovie.data.MovieDataSource;
import com.example.levutantuan.demomvpmovie.data.model.MoviesResponse;
import com.example.levutantuan.demomvpmovie.service.MovieService;
import com.example.levutantuan.demomvpmovie.service.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Age on 3/23/2017.
 */
public class MovieRemoteDataSource implements MovieDataSource {
    private static MovieRemoteDataSource INSTANCE;

    public static MovieRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MovieRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getTasks(@Nullable String api_key, @Nullable int page, final
    @NonNull LoadMovieCallback callback) {
        ServiceGenerator
            .createService(MovieService.class)
            .getNowPlayingMovies(api_key, page)
            .enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call,
                                       Response<MoviesResponse> response) {
                    if (response == null || response.body() == null) return;
                    callback.onMoviesLoaded(response.body().getResults());
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                }
            });
    }

    @Override
    public void loadMovies(String api_key, int page, final LoadMovieCallback callback) {
        ServiceGenerator
            .createService(MovieService.class)
            .getNowPlayingMovies(api_key, page)
            .enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call,
                                       Response<MoviesResponse> response) {
                    if (response == null || response.body() == null) return;
                    callback.onMoviesLoaded(response.body().getResults());
                }


                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                }
            });
    }
}
