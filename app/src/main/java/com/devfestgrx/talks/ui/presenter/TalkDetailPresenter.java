package com.devfestgrx.talks.ui.presenter;

import android.content.Context;

import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.repository.TalksRepository;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

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
        if (talk == null) {
            return;
        }

        this.talk = talk;
    }

    public void onLikeButtonClicked() {
        talk.setLiked(!talk.isLiked());

        if (talk.isLiked()) {
            view.showTalkLiked();
        } else {
            view.showTalkNotLiked();
        }

        //emitTalkStatusChange();
    }

    private void emitTalkStatusChange() {
        Flowable.create(new FlowableOnSubscribe<Talk>() {
            @Override
            public void subscribe(FlowableEmitter<Talk> e) throws Exception {
                e.onNext(talk);
            }
        }, BackpressureStrategy.BUFFER);
    }

    public interface MVPView extends AbsMVPView {

        void showTalkLiked();

        void showTalkNotLiked();
    }

    public interface Navigator extends AbsNavigator {

    }
}