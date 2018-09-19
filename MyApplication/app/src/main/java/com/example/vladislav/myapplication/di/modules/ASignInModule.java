package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.ASignInMvpView;
import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;
import com.example.vladislav.myapplication.managers.FirebaseAuthManager;
import com.example.vladislav.myapplication.presenter.ASignInPresenter;
import com.firebase.ui.auth.AuthUI;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.reactivex.processors.BehaviorProcessor;

@Module
public class ASignInModule {

    @Provides
    ASignInPresenter provideASignInPresenter(BehaviorProcessor<Boolean> behaviorProcessor,
                                             ASignInMvpView view,
                                             SettingsDataSource settingsDataSource,
                                             FirebaseAuthManager authManager) {
         return new ASignInPresenter(behaviorProcessor, view, settingsDataSource, authManager);
    }
}
