package com.example.vladislav.myapplication.Interfaces.view;

import android.content.Intent;

import com.firebase.ui.auth.AuthUI;

import java.util.List;

public interface ASignInMvpView extends MvpView {
    void startAuth(Intent signInIntent);
    void startMainActivity();
}
