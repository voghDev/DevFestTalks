package com.devfestgrx.talks.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.CT;
import com.devfestgrx.talks.global.model.Talk;

import org.parceler.Parcels;

import butterknife.OnClick;

public class TalkDetailActivity extends BaseActivity {
    @OnClick(R.id.talk_detail_ibtn_like)
    public void onClickLike(View v) {
        presenter.onLikeClicked();
    }

    Talk talk;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        talk = Parcels.unwrap(getIntent().getParcelableExtra(CT.EXTRA_TALK));
    }

    public static void open(Context ctx, Talk talk) {
        Intent intent = new Intent(ctx, TalkDetailActivity.class);
        intent.putExtra(CT.EXTRA_TALK, Parcels.wrap(talk));
        ctx.startActivity(intent);
    }
}
