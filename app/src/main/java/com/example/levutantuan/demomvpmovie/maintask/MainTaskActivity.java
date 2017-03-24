package com.example.levutantuan.demomvpmovie.maintask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.levutantuan.demomvpmovie.R;
import com.example.levutantuan.demomvpmovie.data.MovieRepository;
import com.example.levutantuan.demomvpmovie.data.model.Movie;
import com.example.levutantuan.demomvpmovie.data.model.MoviesResponse;
import com.example.levutantuan.demomvpmovie.ui.adapter.NowPlayingAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainTaskActivity extends AppCompatActivity implements MainTaskContract.View {
    private static final String TAG = MainTaskActivity.class.getSimpleName();
    private int mPage = 1;
    private List<Movie> mMovieList = new ArrayList<>();
    private MainTaskContract.Presenter mPresenter;
    private NowPlayingAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainTaskPresenter(this, MovieRepository.getInstance(this));
        start();
        mPresenter.start();
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_now_playing);
        mLinearLayout = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayout);
        setupRecycleView();
    }

    private void setupRecycleView() {
        mAdapter = new NowPlayingAdapter(this, mMovieList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loaddataView(MoviesResponse listMovie) {
        mMovieList.addAll(listMovie.getResults());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void start() {
        initViews();
    }

    @Override
    public void LoadlistOk() {
        Toast.makeText(this, R.string.msg_loadok, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoadlistError() {
        Toast.makeText(this, R.string.loaderror, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showViewLoadList(List<Movie> movieList) {
        mAdapter.updateData(movieList);
    }
}
