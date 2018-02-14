package com.devfestgrx.talks.repository;

import com.devfestgrx.talks.usecase.GetTalks;

/**
 * Created by olmo on 19/11/16.
 */
public class TalksRepository implements GetTalks {
    GetTalks getTalksMockDataSource;
    GetTalks getGetTalksApiDataSource;

    public TalksRepository(GetTalks getTalksMockDataSource, GetTalks getGetTalksApiDataSource) {
        this.getTalksMockDataSource = getTalksMockDataSource;
        this.getGetTalksApiDataSource = getGetTalksApiDataSource;
    }

    @Override
    public void getTalks(Listener listener) {
        getTalksMockDataSource.getTalks(listener);
    }
}
