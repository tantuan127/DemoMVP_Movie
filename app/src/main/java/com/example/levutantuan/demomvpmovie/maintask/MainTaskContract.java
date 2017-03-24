package com.example.levutantuan.demomvpmovie.maintask;

import com.example.levutantuan.demomvpmovie.BasePresenter;
import com.example.levutantuan.demomvpmovie.BaseView;
import com.example.levutantuan.demomvpmovie.data.model.Movie;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public interface MainTaskContract {
    interface View extends BaseView {
        void LoadlistOk();
        void LoadlistError();
        void showViewLoadList(List<Movie> movieList);
    }
    interface Presenter extends BasePresenter {
        void getPresenterList(int page);
    }
}
