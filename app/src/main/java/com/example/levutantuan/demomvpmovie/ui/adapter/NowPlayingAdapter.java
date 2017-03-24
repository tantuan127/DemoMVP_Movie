package com.example.levutantuan.demomvpmovie.ui.adapter;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.levutantuan.demomvpmovie.data.model.Movie;
import com.example.levutantuan.demomvpmovie.databinding.ItemDataBinding;
import com.example.levutantuan.demomvpmovie.ui.interactor.OnItemClickListener;

import java.util.List;

/**
 * Created by Age on 3/23/2017.
 */
public class NowPlayingAdapter extends RecyclerView.Adapter<NowPlayingAdapter.ViewHolder>
    implements View.OnClickListener {
    private OnItemClickListener mItemClickListener;
    private List<Movie> mList;
    private LayoutInflater mLayoutInflater;
    private ItemDataBinding mDataBinding;
    private Context mContext;

    public NowPlayingAdapter(Context Context, List<Movie> list) {
        mList = list;
        mContext = Context;
    }

    public void updateData(List<Movie> movies) {
        mList.clear();
        if (movies != null) mList.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        mDataBinding = ItemDataBinding.inflate(mLayoutInflater, parent, false);
        return new ViewHolder(mDataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mList.get(position);
        holder.bindData(movie);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onClick(View v) {
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ObservableField<String> mTitle = new ObservableField<>();
        public ObservableField<String> mOverview = new ObservableField<>();
        public ObservableField<String> mVote = new ObservableField<>();
        public ItemDataBinding mDataBinding;

        public ViewHolder(ItemDataBinding dataBinding) {
            super(dataBinding.getRoot());
            mDataBinding = dataBinding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(mList.get(getPosition()));
            }
        }

        public void bindData(Movie movie) {
            if (movie == null) return;
            mDataBinding.setItemview(movie);
//            Picasso.with(mContext)
//                .load(ServiceGenerator.BASE_IMAGE_URL + movie.getPosterPath())
//                .placeholder(R.drawable.bg_no_img)
//                .into(mImageView);
        }
    }
}
