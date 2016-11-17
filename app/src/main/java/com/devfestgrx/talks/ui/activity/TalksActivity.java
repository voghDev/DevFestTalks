package com.devfestgrx.talks.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;

import butterknife.Bind;

public class TalksActivity extends BaseActivity implements TalksPresenter.MVPView, TalksPresenter.Navigator {
    @Bind(R.id.talks_recyclerView)
    RecyclerView recyclerView;

    TalksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new TalksPresenter(this);
        presenter.setView(this);
        presenter.setNavigator(this);

        presenter.initialize();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talks;
    }
}
