package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.Interfaces.view.MainMvpView;
import com.example.vladislav.myapplication.activity.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AMainViewModule {

    @Binds
    abstract MainMvpView provideMainMvpView(MainActivity activity);
}
