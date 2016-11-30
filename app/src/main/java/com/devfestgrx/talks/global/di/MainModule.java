package com.devfestgrx.talks.global.di;

import com.devfestgrx.talks.datasource.api.GetTalksApiImpl;
import com.devfestgrx.talks.datasource.mock.GetTalksMockImpl;
import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.repository.TalksRepository;
import com.devfestgrx.talks.usecase.get.GetTalks;

import dagger.Module;
import dagger.Provides;

/**
 * Created by olmo on 19/11/16.
 */

@Module
public class MainModule {
    App application;
    TalksRepository talkRepository;

    public MainModule(App application) {
        this.application = application;

        GetTalks getTalksMockDataSource = new GetTalksMockImpl();
        GetTalks getTalksApiDataSource = new GetTalksApiImpl();

        talkRepository = new TalksRepository(getTalksMockDataSource, getTalksApiDataSource);
        getTalksApiDataSource.getTalks(null);
    }

    @Provides
    public GetTalks provideGetTalks() {
        return talkRepository;
    }
}
