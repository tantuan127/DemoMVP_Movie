package com.example.levutantuan.demomvpmovie.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("genre_ids")
    private List<Integer> mGenreIds = new ArrayList<Integer>();
    @SerializedName("id")
    private Integer mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("vote_average")
    private String mVoteAverage;
    private int mFavorites;

    public Movie() {
    }

    public Movie(String posterPath, String overview, String releaseDate,
                 List<Integer> genreIds, Integer id, String title, String backdropPath,
                 String voteAverage, int favorites) {
        mPosterPath = posterPath;
        mOverview = overview;
        mReleaseDate = releaseDate;
        mGenreIds = genreIds;
        mId = id;
        mTitle = title;
        mBackdropPath = backdropPath;
        mVoteAverage = voteAverage;
        mFavorites = favorites;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
    }

    public int getFavorites() {
        return mFavorites;
    }

    public void setFavorites(int favorites) {
        mFavorites = favorites;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        this.mPosterPath = posterPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        this.mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.mReleaseDate = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return mGenreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.mGenreIds = genreIds;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.mBackdropPath = backdropPath;
    }
}
