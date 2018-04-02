package com.example.vladislav.myapplication;

import android.app.Application;
import android.text.TextUtils;

import com.example.vladislav.myapplication.Data.Login;
import com.example.vladislav.myapplication.Interfaces.Api;
import com.example.vladislav.myapplication.Interfaces.RealApiLoftSchool;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private final static String PREFS_NAME = "login";
    private final static String KEY_TOKEN = "token";
    private final static String URL_TEST = "https://verdant-violet.glitch.me/";
    private final static String REAL_URL = BuildConfig.BASE_URL;

    static Api api;

    static RealApiLoftSchool apiLoftSchool;

    @Override
    public void onCreate() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(REAL_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        super.onCreate();
        apiLoftSchool = retrofit.create(RealApiLoftSchool.class);
    }
    public static Api getApi() {
        return api;
    }
    public static RealApiLoftSchool getApiLoftSchool() {
        return apiLoftSchool;
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
}
