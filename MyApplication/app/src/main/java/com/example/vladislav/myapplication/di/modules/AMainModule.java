package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.AMainMvpView;
import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;
import com.example.vladislav.myapplication.Support.SettingsLocalDataSource;
import com.example.vladislav.myapplication.presenter.AMainPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.processors.BehaviorProcessor;

@Module
public class AMainModule {

    @Provides
    public AMainPresenter provideMainPresenter(BehaviorProcessor<Boolean> eventProcessor, AMainMvpView view,
                                               SettingsDataSource settingsDataSource) {
        return new AMainPresenter(eventProcessor, view, settingsDataSource);
    }
}
