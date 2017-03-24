package com.example.levutantuan.demomvpmovie.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.levutantuan.demomvpmovie.data.model.Movie;
import com.example.levutantuan.demomvpmovie.data.source.remote.MovieRemoteDataSource;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public class MovieRepository implements MovieDataSource {
    private static MovieRepository sMovieRepository;
    private final MovieDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public static MovieRepository getInstance(Context context) {
        if (sMovieRepository == null)
            return new MovieRepository(MovieRemoteDataSource.getInstance());
        return sMovieRepository;
    }

    @Override
    public void getTasks(@Nullable String api_key, @Nullable int page,
                         @NonNull final LoadMovieCallback callback) {
        mMovieRemoteDataSource.getTasks(api_key, page, new LoadMovieCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
            }
        });
    }

    @Override
    public void loadMovies(String api_key, int page, LoadMovieCallback callback) {
    }
}
