package com.devfestgrx.talks.datasource.api;

import com.devfestgrx.talks.usecase.get.GetTalks;

/**
 * Created by olmo on 24/11/16.
 */
public class GetTalksApiImpl implements GetTalks {
    @Override
    public void getTalks(Listener listener) {
        // TODO make retrofit2 request to talks API

        // listener.onTalksCompleted(array);
    }
}
