package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.AMainMvpView;
import com.example.vladislav.myapplication.activity.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AMainViewModule {

    @Binds
    abstract AMainMvpView provideMainMvpView(MainActivity activity);
}
