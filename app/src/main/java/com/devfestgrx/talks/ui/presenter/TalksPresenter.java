package com.devfestgrx.talks.ui.presenter;

import android.content.Context;

/**
 * Created by olmo on 17/11/16.
 */
public class TalksPresenter extends Presenter<TalksPresenter.MVPView, TalksPresenter.Navigator> {
    Context context;

    public TalksPresenter(Context context) {
        this.context = context;
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

    public interface MVPView extends AbsMVPView {

    }

    public interface Navigator extends AbsNavigator {

    }
}