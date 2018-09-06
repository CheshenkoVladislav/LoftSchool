package com.example.vladislav.myapplication.di.modules.builders;

import com.example.vladislav.myapplication.BuildConfig;
import com.example.vladislav.myapplication.Support.MoneyTrackerInterceptor;
import com.example.vladislav.myapplication.api.TestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import junit.framework.Test;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vladislav.myapplication.BuildConfig.BASE_URL;
import static com.example.vladislav.myapplication.BuildConfig.CONNECTION_TIMEOUT;
import static com.example.vladislav.myapplication.BuildConfig.TEST_URL;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    MoneyTrackerInterceptor provideMoneyTrackerInterceptor() {
        return new MoneyTrackerInterceptor();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(MoneyTrackerInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit proviceRetrofitClient(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(TEST_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Singleton
    @Provides
    TestApi provideTestApi(Retrofit retrofit) {
        return retrofit.create(TestApi.class);
    }
}
