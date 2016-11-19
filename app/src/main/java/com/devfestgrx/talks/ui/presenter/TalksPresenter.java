package com.devfestgrx.talks.ui.presenter;

import android.content.Context;

import com.devfestgrx.talks.R;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.usecase.GetTalks;

import java.util.List;

/**
 * Created by olmo on 17/11/16.
 */
public class TalksPresenter extends Presenter<TalksPresenter.MVPView, TalksPresenter.Navigator> {
    Context context;
    GetTalks getTalks;

    public TalksPresenter(Context context, GetTalks getTalks) {
        this.context = context;
        this.getTalks = getTalks;
    }

    @Override
    public void initialize() {
        view.showLoading();
        getTalks.getTalks(new GetTalks.Listener() {
            @Override
            public void onTalksCompleted(List<Talk> list) {
                view.showTalks(list);
                view.hideLoading();
            }

            @Override
            public void onError(Exception e) {
                view.showError(e.getMessage());
                view.hideLoading();
            }

            @Override
            public void onNoInternetAvailable() {
                view.showError(context.getString(R.string.no_internet));
                view.hideLoading();
            }
        });
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

        void showLoading();

        void hideLoading();

        void showError(String message);

        void showTalks(List<Talk> list);
    }

    public interface Navigator extends AbsNavigator {

    }
}