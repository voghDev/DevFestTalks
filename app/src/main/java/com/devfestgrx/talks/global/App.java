package com.devfestgrx.talks.global;

import android.app.Application;

import com.devfestgrx.talks.global.di.DaggerRootComponent;
import com.devfestgrx.talks.global.di.MainModule;
import com.devfestgrx.talks.global.di.RootComponent;

/**
 * Created by olmo on 19/11/16.
 */
public class App extends Application {

    private RootComponent component;
    private MainModule mainModule;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeDependencyInjection();
    }

    private void initializeDependencyInjection() {
        mainModule = new MainModule(this);
        component = DaggerRootComponent.builder()
                .mainModule(mainModule)
                .build();
        component.inject(this);
    }

    public MainModule getMainModule() {
        return mainModule;
    }

    public RootComponent getComponent() {
        return component;
    }
}
