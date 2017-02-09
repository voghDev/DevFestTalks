package com.devfestgrx.talks.ui.renderer;

import android.content.Context;
import android.database.Observable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.ui.picasso.RoundedTransformation;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by olmo on 19/11/16.
 */
public class TalkRenderer extends ListEntityRenderer {
    @Bind(R.id.talk_tv_title)
    TextView tvTitle;

    @Bind(R.id.talk_tv_description)
    TextView tvDescription;

    @Bind(R.id.talk_iv_thumbnail)
    ImageView ivThumbnail;

    @OnClick(R.id.talk_container)
    public void onClickRootView(View v) {
        listener.onRowBackgroundClicked(getContent());
    }

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
        renderThumbnail(obj);

        Flowable.just("Like").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }

    private void renderThumbnail(Talk obj) {
        if (obj.hasImage()) {
            Picasso.with(context)
                    .load(obj.getImageUrl())
                    .transform(new RoundedTransformation())
                    .into(ivThumbnail);
        } else {
            Picasso.with(context)
                    .load(R.mipmap.ic_user_avatar)
                    .into(ivThumbnail);
        }
    }

    private void renderSubtitle(Talk obj) {
        tvDescription.setText(obj.getText());
    }

    private void renderTitle(Talk obj) {
        tvTitle.setText(obj.getTitle());
    }
}