package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.ASignInMvpView;
import com.example.vladislav.myapplication.presenter.ASignInPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.processors.BehaviorProcessor;

@Module
public class ASignInModule {

    @Provides
    ASignInPresenter proviceASignInPresenter(BehaviorProcessor<Boolean> behaviorProcessor, ASignInMvpView view) {
         return new ASignInPresenter(behaviorProcessor, view);
    }
}
