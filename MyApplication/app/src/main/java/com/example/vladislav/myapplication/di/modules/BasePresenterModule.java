package com.example.vladislav.myapplication.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.processors.BehaviorProcessor;

@Module
public class BasePresenterModule {

    @Provides
    public BehaviorProcessor<Boolean> provideBehaviorProcessor () {
        return BehaviorProcessor.createDefault(false);
    }
}
