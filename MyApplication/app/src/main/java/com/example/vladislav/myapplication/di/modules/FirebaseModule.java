package com.example.vladislav.myapplication.di.modules;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Singleton
    @Provides
    List<AuthUI.IdpConfig> provideFirebaseSignInProviders() {
        return Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );
    }
}
