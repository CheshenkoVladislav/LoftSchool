package com.example.vladislav.myapplication.di.modules;

import com.example.vladislav.myapplication.BuildConfig;
import com.example.vladislav.myapplication.Support.MoneyTrackerInterceptor;
import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.managers.RestManager;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    public RealApiLoftSchool provideRealApiLoftSchool(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RealApiLoftSchool.class);
    }

    public OkHttpClient provideOkHttpClient (Interceptor interceptor) {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .writeTimeout(BuildConfig.READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(BuildConfig.READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(BuildConfig.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public Interceptor provideInterceptor() {
        return new MoneyTrackerInterceptor();
    }
}
