package com.devfestgrx.talks.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;
import com.devfestgrx.talks.usecase.GetTalks;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class TalksActivity extends BaseActivity implements TalksPresenter.MVPView, TalksPresenter.Navigator {
    @Bind(R.id.talks_recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.talks_pbr_loading)
    ProgressBar pbrLoading;

    TalksPresenter presenter;

    //@Inject
    GetTalks getTalks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new TalksPresenter(this, getTalks);
        presenter.setView(this);
        presenter.setNavigator(this);

        presenter.initialize();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talks;
    }

    @Override
    public void showLoading() {
        pbrLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideLoading() {
        pbrLoading.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        // TODO implement error handling
    }

    @Override
    public void showTalks(List<Talk> list) {
        // TODO implement
    }
}
