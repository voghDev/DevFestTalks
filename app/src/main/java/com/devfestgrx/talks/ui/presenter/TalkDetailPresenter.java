package com.devfestgrx.talks.ui.presenter;

import android.content.Context;

import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.repository.TalksRepository;

public class TalkDetailPresenter extends Presenter<TalkDetailPresenter.MVPView, TalkDetailPresenter.Navigator> {
    Context context;
    TalksRepository talksRepository;
    Talk talk;

    public TalkDetailPresenter(Context context, TalksRepository talksRepository) {
        this.context = context;
        this.talksRepository = talksRepository;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void onTalkReceivedFromExtras(Talk talk) {
        if (talk == null)
            return;

        this.talk = talk;
    }

    public void onLikeButtonClicked() {
        talk.setLiked(true);
    }

    public interface MVPView extends AbsMVPView {

    }

    public interface Navigator extends AbsNavigator {

    }
}