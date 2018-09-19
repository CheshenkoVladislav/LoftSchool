package com.example.vladislav.myapplication.di.modules;

import android.content.Context;

import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.managers.FirebaseAuthManager;
import com.example.vladislav.myapplication.managers.RestManager;
import com.firebase.ui.auth.AuthUI;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagersModule {

    @Singleton
    @Provides
    RestManager provideRestManager (RealApiLoftSchool apiLoftSchool) {
        return new RestManager(apiLoftSchool);
    }

    @Singleton
    @Provides
    FirebaseAuthManager provideFirebaseAuthManager (List<AuthUI.IdpConfig> authProviders, Context context) {
        return new FirebaseAuthManager(authProviders, context);
    }
}
