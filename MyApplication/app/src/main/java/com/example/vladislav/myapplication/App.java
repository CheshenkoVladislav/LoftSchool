package com.example.vladislav.myapplication;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private final static String URL = "https://verdant-violet.glitch.me/";
    static Api api;
    @Override
    public void onCreate() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        super.onCreate();
        api = retrofit.create(Api.class);
    }
    public static Api getApi() {
        return api;
    }
}
