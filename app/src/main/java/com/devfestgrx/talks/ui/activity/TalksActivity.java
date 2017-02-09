package com.devfestgrx.talks.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.repository.TalksRepository;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;
import com.devfestgrx.talks.ui.renderer.ListEntity;
import com.devfestgrx.talks.ui.renderer.ListEntityRenderer;
import com.devfestgrx.talks.ui.renderer.ListEntityRendererBuilder;
import com.devfestgrx.talks.ui.renderer.TalkListEntity;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class TalksActivity extends BaseActivity implements TalksPresenter.MVPView, TalksPresenter.Navigator,
        ListEntityRenderer.OnRowClicked {
    @Bind(R.id.talks_recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.talks_pbr_loading)
    ProgressBar pbrLoading;

    TalksPresenter presenter;
    RVRendererAdapter<ListEntity> adapter;

    @Inject
    TalksRepository getTalks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);

        adapter = new RVRendererAdapter<ListEntity>(
                LayoutInflater.from(this),
                new ListEntityRendererBuilder(this, this),
                new ListAdapteeCollection<ListEntity>(new ArrayList<ListEntity>()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        for (Talk talk : list) {
            adapter.add(new TalkListEntity(talk));
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRowBackgroundClicked(ListEntity i) {
        Talk talk = ((TalkListEntity) i).getTalk();
        presenter.onTalkClicked(talk);
    }

    @Override
    public void onWidget1Clicked(ListEntity i) {

    }

    @Override
    public void onWidget2Clicked(ListEntity i) {

    }

    @Override
    public void onWidget3Clicked(ListEntity i) {

    }

    @Override
    public void onWidget4Clicked(ListEntity i) {

    }

    @Override
    public void onWidget5Clicked(ListEntity i) {

    }

    @Override
    public void navigateToTalkActivity(Talk talk) {
        TalkDetailActivity.open(this, talk);
    }
}
