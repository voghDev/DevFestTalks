package com.devfestgrx.talks.usecase;

import com.devfestgrx.talks.global.model.Talk;

import java.util.List;

public interface GetTalks {
    void getTalks(final Listener listener);

    interface Listener {
        void onTalksCompleted(final List<Talk> list);
        void onError(Exception e);
        void onNoInternetAvailable();
    }
}