package com.devfestgrx.talks.repository;

import com.devfestgrx.talks.usecase.get.GetTalks;

/**
 * Created by olmo on 24/11/16.
 */
public class TalksRepository implements GetTalks {
    //InsertTalk, DeleteTalk
    GetTalks getTalksMockDataSource;
    GetTalks getTalksApiDataSource;

    public TalksRepository(GetTalks getTalksMockDataSource, GetTalks getTalksApiDataSource) {
        this.getTalksMockDataSource = getTalksMockDataSource;
        this.getTalksApiDataSource = getTalksApiDataSource;
    }

    @Override
    public void getTalks(Listener listener) {
        getTalksMockDataSource.getTalks(listener);
    }
}
