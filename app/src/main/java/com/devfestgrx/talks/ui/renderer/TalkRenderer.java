package com.devfestgrx.talks.ui.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by olmo on 24/11/16.
 */
public class TalkRenderer extends ListEntityRenderer {
    @Bind(R.id.talk_tv_title)
    TextView tvTitle;

    @Bind(R.id.talk_tv_description)
    TextView tvDescription;

    @Bind(R.id.talk_iv_thumbnail)
    ImageView imageView;

    @OnClick(R.id.talk_rootView)
    public void onClickRowBackground(View v) {
        listener.onRowBackgroundClicked(getContent());
    }


    public TalkRenderer(Context ctx, OnRowClicked onRowClicked) {
        context = ctx.getApplicationContext();
        setListener(onRowClicked);
    }

    @Override
    protected void hookListeners(View rootView) {

    }

    @Override
    protected void setUpView(View rootView) {
        ButterKnife.bind(this, rootView);
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
    }

    private void renderTitle(Talk obj) {
        tvTitle.setText(obj.getTitle());
    }

    private void renderSubtitle(Talk obj) {
        tvDescription.setText(obj.getText());
    }

    private void renderThumbnail(Talk obj) {
        if (obj.hasPicture()) {

            Picasso.with(context)
                    .load(obj.getImageUrl())
                    .into(imageView);
        } else {
            Picasso.with(context)
                    .load(R.mipmap.image_placeholder)
                    .into(imageView);
        }
    }
}
