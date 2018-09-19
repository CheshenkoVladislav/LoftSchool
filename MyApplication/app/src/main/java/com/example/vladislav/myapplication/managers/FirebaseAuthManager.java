package com.example.vladislav.myapplication.managers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.List;

import javax.inject.Singleton;

@Singleton
public class FirebaseAuthManager {

    private List<AuthUI.IdpConfig> authProviders;
    private Context context;

    public FirebaseAuthManager(List<AuthUI.IdpConfig> authProviders, Context context) {
        this.authProviders = authProviders;
        this.context = context;
    }

    public Intent getSignInIntent() {
        return AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(authProviders)
                .build();
    }

    public void signOut(OnCompleteListener<Void> completeSignOutListener) {
        AuthUI.getInstance()
                .delete(context)
                .addOnCompleteListener(completeSignOutListener);
    }
}
