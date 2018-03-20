package com.example.vladislav.myapplication;

import android.app.Application;
import android.util.Log;

import com.example.vladislav.myapplication.API.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static final String TAG = "App";
    private final static String URL = "https://verdant-violet.glitch.me/";

    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    Api api;

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
