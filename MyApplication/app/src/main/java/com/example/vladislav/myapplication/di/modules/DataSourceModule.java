package com.example.vladislav.myapplication.di.modules;

import android.content.SharedPreferences;

import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;
import com.example.vladislav.myapplication.Support.SettingsLocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataSourceModule {

    @Provides
    @Singleton
    public SettingsDataSource provideSettingsLocalDataSource(SharedPreferences sharedPreferences) {
        return new SettingsLocalDataSource(sharedPreferences);
    }
}
