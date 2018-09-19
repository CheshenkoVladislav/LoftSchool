package com.example.vladislav.myapplication.Support;

import com.bumptech.glide.RequestBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MoneyTrackerInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Request.Builder originBuilder = originRequest.newBuilder();

        return chain.proceed(originBuilder.build());
    }
}
