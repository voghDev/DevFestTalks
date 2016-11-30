package com.devfestgrx.talks.usecase.get;

import com.devfestgrx.talks.global.model.Talk;

import java.util.List;

/**
 * Created by olmo on 24/11/16.
 */

public interface GetTalks {
    void getTalks(final Listener listener);

    interface Listener {
        void onTalksCompleted(final List<Talk> list);
        void onError(Exception e);
        void onNoInternetAvailable();
    }
}
