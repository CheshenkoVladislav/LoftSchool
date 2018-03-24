package com.example.vladislav.myapplication;

import android.app.Application;
<<<<<<< HEAD

import com.example.vladislav.myapplication.Interfaces.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vladislav on 18.03.18.
 */

public class App extends Application {
    private Api api;
    private final String URL = "https://verdant-violet.glitch.me/";
    @Override
    public void onCreate() {
        super.onCreate();
        Gson gson = new GsonBuilder().create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
=======
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
>>>>>>> exercise_5
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
<<<<<<< HEAD
        api = retrofit.create(Api.class);
    }
=======
        super.onCreate();
        api = retrofit.create(Api.class);
    }
    public static Api getApi() {
        return api;
    }
>>>>>>> exercise_5
}
