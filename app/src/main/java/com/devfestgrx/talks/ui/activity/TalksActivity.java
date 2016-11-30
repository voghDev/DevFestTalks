/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.devfestgrx.talks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.global.di.RootComponent;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;
import com.devfestgrx.talks.ui.renderer.ListEntity;
import com.devfestgrx.talks.ui.renderer.ListEntityRenderer;
import com.devfestgrx.talks.ui.renderer.ListEntityRendererBuilder;
import com.devfestgrx.talks.ui.renderer.TalkListEntity;
import com.devfestgrx.talks.usecase.get.GetTalks;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

public class TalksActivity extends BaseActivity implements TalksPresenter.MVPView,
        TalksPresenter.Navigator, ListEntityRenderer.OnRowClicked {

    @Bind(R.id.talks_progressBar)
    ProgressBar progressBar;

    @Bind(R.id.talks_recyclerView)
    RecyclerView recyclerView;

    TalksPresenter presenter;

    @Inject
    GetTalks talksRepository;
    RVRendererAdapter<ListEntity> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);

        adapter = new RVRendererAdapter<ListEntity>(
                LayoutInflater.from(this),
                new ListEntityRendererBuilder(this, this),
                new ListAdapteeCollection<ListEntity>(new ArrayList<ListEntity>()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new TalksPresenter(this, talksRepository);
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
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showNoInternetMessage() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showTalks(List<Talk> list) {
        for (Talk talk : list) {
            adapter.add(new TalkListEntity(talk));
        }

        adapter.notifyDataSetChanged();
    }

    protected RootComponent getComponent() {
        return ((App) getApplicationContext()).getComponent();
    }

    @Override
    public void onRowBackgroundClicked(ListEntity listEntity) {
        Talk obj = ((TalkListEntity) listEntity).getTalk();
        presenter.onRowClicked(obj);
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
    public void navigateToTalkDetailActivity(Talk talk) {
        Intent intent = new Intent(this, TalkDetailActivity.class);
        // intent.putExtra(CT.EXTRA_TALK, talk);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
