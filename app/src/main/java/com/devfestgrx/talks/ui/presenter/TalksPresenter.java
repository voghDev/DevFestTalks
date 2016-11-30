package com.devfestgrx.talks.ui.presenter;

import android.content.Context;

import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.global.di.RootComponent;
import com.devfestgrx.talks.global.model.Talk;
import com.devfestgrx.talks.usecase.get.GetTalks;

import java.util.List;

/**
 * Created by olmo on 24/11/16.
 */
public class TalksPresenter extends Presenter<TalksPresenter.MVPView, TalksPresenter.Navigator> {
    Context context;

    //@Inject
    GetTalks getTalks;

    public TalksPresenter(Context context, GetTalks talksRepository) {
        this.context = context;
        this.getTalks = talksRepository;
    }

    @Override
    public void initialize() {
        showLoadingStatus();

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
                view.showNoInternetMessage();
                view.hideLoading();
            }
        });
    }

    private void showLoadingStatus() {
        view.showLoading();
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

    protected RootComponent getComponent() {
        return ((App) context.getApplicationContext()).getComponent();
    }

    public void onRowClicked(Talk obj) {
        navigator.navigateToTalkDetailActivity(obj);
    }

    public interface MVPView extends AbsMVPView {

        void showLoading();

        void showNoInternetMessage();

        void showError(String message);

        void hideLoading();

        void showTalks(List<Talk> list);
    }

    public interface Navigator extends AbsNavigator {

        void navigateToTalkDetailActivity(Talk obj);
    }
}