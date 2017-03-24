package com.example.levutantuan.demomvpmovie.maintask;

import com.example.levutantuan.demomvpmovie.BuildConfig;
import com.example.levutantuan.demomvpmovie.data.MovieDataSource;
import com.example.levutantuan.demomvpmovie.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public class MainTaskPresenter implements MainTaskContract.Presenter {
    private MainTaskContract.View mView;
    private MovieDataSource mMovieRepository;

    public MainTaskPresenter(MainTaskContract.View view,
                             MovieDataSource movieRepository) {
        mView = view;
        mMovieRepository = movieRepository;
    }

    @Override
    public void start() {
        loadData(1);
    }

    private void loadData(int page) {
        getPresenterList(page);
    }

    @Override
    public void getPresenterList(int page) {
        mMovieRepository.getTasks(BuildConfig.API_KEY, page,
            new MovieDataSource.LoadMovieCallback() {
                @Override
                public void onMoviesLoaded(List<Movie> movies) {
                    mView.showViewLoadList(movies);
                    mView.LoadlistOk();
                }

                @Override
                public void onDataNotAvailable() {
                    mView.LoadlistError();
                }
            });
    }
}
