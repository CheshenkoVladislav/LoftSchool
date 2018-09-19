package com.example.vladislav.myapplication.di.modules;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    @Singleton
    @Provides
    DatabaseReference provideDatabase() {
        return FirebaseDatabase.getInstance().getReference("users");
    }
}
