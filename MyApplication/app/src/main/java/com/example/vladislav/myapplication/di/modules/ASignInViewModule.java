package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.ASignInMvpView;
import com.example.vladislav.myapplication.activity.SignInActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ASignInViewModule {

    @Binds
    abstract ASignInMvpView provideASignInActivityMvpView(SignInActivity activity);
}
