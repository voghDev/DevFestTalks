package com.devfestgrx.talks;

import android.content.Context;

import com.devfestgrx.talks.global.App;
import com.devfestgrx.talks.global.di.MainModule;
import com.devfestgrx.talks.global.di.RootComponent;
import com.devfestgrx.talks.ui.presenter.TalksPresenter;
import com.devfestgrx.talks.usecase.GetTalks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityTest {
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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
        return presenter;
    }

    @Test
    public void shouldCreateAllTheseMocksAndNoneOfThemIsNull() throws Exception {
        givenAMockedEnvironment();

        assertNotNull(mockGetTalks);
        assertNotNull(mockApp);
        assertNotNull(mockComponent);
        assertNotNull(mockModule);
        assertNotNull(mockContext);
        assertNotNull(mockView);
    }

    @Test
    public void shouldShowLoadingWhenActivityIsEntered() throws Exception {
        presenter = givenAMockedPresenter();

        presenter.initialize();

        verify(mockView, times(1)).showLoading();
    }

    @Test
    public void shouldRequestTalksListWhenActivityIsEntered() throws Exception {
        presenter = givenAMockedPresenter();

        presenter.initialize();

        verify(mockGetTalks, times(1)).getTalks(any(GetTalks.Listener.class));
    }
}