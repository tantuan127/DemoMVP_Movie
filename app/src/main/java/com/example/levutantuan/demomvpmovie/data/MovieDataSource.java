package com.example.levutantuan.demomvpmovie.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.levutantuan.demomvpmovie.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public interface MovieDataSource {
    void getTasks(@Nullable String api_key, @Nullable int page, @NonNull LoadMovieCallback
        callback);
    void loadMovies(String api_key, int page, LoadMovieCallback
        callback);
    interface LoadMovieCallback {
        void onMoviesLoaded(List<Movie> movies);
        void onDataNotAvailable();
    }
}
