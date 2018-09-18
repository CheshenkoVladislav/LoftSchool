package com.example.vladislav.myapplication.app;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;

import com.example.vladislav.myapplication.BuildConfig;
import com.example.vladislav.myapplication.api.Api;
import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.di.component.AppComponent;
import com.example.vladislav.myapplication.di.component.DaggerAppComponent;
import com.example.vladislav.myapplication.di.modules.builders.NetworkModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application implements HasActivityInjector {

    private final static String PREFS_NAME = "login";
    private final static String KEY_TOKEN = "token";

    private AppComponent component;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        getOrCreateComponent().inject(this);
    }

    AppComponent getOrCreateComponent() {
        if (component == null)
            component = DaggerAppComponent.builder()
                    .app(this)
                    .moduleNetwork(new NetworkModule())
                    .build();
        return component;
    }

    public void saveAuthToken(String login){
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(KEY_TOKEN, login)
                .apply();
    }
    public String getAuthToken(){
        return getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .getString(KEY_TOKEN,null);
    }
    public boolean isLogin(){
        return !TextUtils.isEmpty(getAuthToken());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
