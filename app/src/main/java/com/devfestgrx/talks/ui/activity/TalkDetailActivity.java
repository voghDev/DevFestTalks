package com.devfestgrx.talks.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.CT;
import com.devfestgrx.talks.global.model.Talk;

import org.parceler.Parcels;

/**
 * Created by olmo on 17/11/16.
 */
public class TalkDetailActivity extends BaseActivity {
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
