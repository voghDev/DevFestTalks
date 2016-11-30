package com.devfestgrx.talks.ui.activity;

import android.os.Bundle;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.CT;

/**
 * Created by olmo on 24/11/16.
 */

public class TalkDetailActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_talk_detail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntent().getParcelableExtra(CT.EXTRA_TALK);
    }
}
