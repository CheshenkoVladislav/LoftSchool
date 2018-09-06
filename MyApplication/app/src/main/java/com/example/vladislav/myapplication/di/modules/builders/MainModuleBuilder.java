package com.example.vladislav.myapplication.di.modules.builders;

import com.example.vladislav.myapplication.activity.MainActivity;
import com.example.vladislav.myapplication.di.modules.AMainModule;
import com.example.vladislav.myapplication.di.modules.AMainViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModuleBuilder {

    @ContributesAndroidInjector(modules = {AMainViewModule.class, AMainModule.class})
    abstract MainActivity bindMainActivity();
}
