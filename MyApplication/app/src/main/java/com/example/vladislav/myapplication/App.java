package com.example.vladislav.myapplication;

import android.app.Application;
import android.util.Log;

import com.example.vladislav.myapplication.API.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static final String TAG = "App";
    Api api;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://loftschoolandroid.getsandbox.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: s");
        super.onCreate();
        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}
