package com.devfestgrx.talks.ui.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;

import butterknife.ButterKnife;

/**
 * Created by olmo on 19/11/16.
 */
public class TalkRenderer extends ListEntityRenderer {
    protected OnRowClicked listener = new EmptyListener();

    public TalkRenderer(Context ctx, OnRowClicked onRowClicked) {
        context = ctx.getApplicationContext();
        setListener(onRowClicked);
    }

    @Override
    protected void setUpView(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    @Override
    protected void hookListeners(View rootView) {

    }

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(R.layout.row_talk, parent, false);
    }

    @Override
    public void render() {
        Talk obj = ((TalkListEntity) getContent()).getTalk();
        renderTitle(obj);
        renderSubtitle(obj);
    }

    private void renderSubtitle(Talk obj) {

    }

    private void renderTitle(Talk obj) {

    }
}