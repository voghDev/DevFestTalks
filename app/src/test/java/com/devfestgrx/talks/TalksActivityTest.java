package com.devfestgrx.talks;

import android.content.Context;

import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.global.di.MainModule;
import com.devfestgrx.talks.global.di.RootComponent;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;
import com.devfestgrx.talks.usecase.get.GetTalks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TalksActivityTest {
    @Mock
    GetTalks mockGetTalks;
    @Mock
    TalksPresenter presenter;
    @Mock
    App mockApp;
    @Mock
    RootComponent mockComponent;
    @Mock
    MainModule mockModule;
    @Mock
    Context mockContext;
    @Mock
    TalksPresenter.MVPView mockView;
    @Mock
    TalksPresenter.Navigator mockNavigator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldShowLoadingWhenTalksActivityIsEntered() throws Exception {
        presenter = givenAMockedPresenter();

        presenter.initialize();

        verify(mockView, times(1)).showLoading();
    }

    private void givenAMockedEnvironment() {
        when(mockContext.getApplicationContext()).thenReturn(mockApp);
        when(mockApp.getComponent()).thenReturn(mockComponent);
        when(mockApp.getMainModule()).thenReturn(mockModule);
    }

    private TalksPresenter givenAMockedPresenter() {
        givenAMockedEnvironment();
        TalksPresenter presenter = new TalksPresenter(mockContext, mockGetTalks);
        presenter.setView(mockView);
        presenter.setNavigator(mockNavigator);
        return presenter;
    }
}