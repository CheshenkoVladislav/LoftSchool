package com.example.vladislav.myapplication.di.modules;

import android.content.Context;

import com.example.vladislav.myapplication.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.processors.BehaviorProcessor;

@Module
public class MainModule {

    @Provides
    public BehaviorProcessor<Boolean> provideBehaviorProcessor () {
        return BehaviorProcessor.createDefault(false);
    }

    @Singleton
    @Provides
    public Context provideContext(App app) {
        return app.getApplicationContext();
    }
}
