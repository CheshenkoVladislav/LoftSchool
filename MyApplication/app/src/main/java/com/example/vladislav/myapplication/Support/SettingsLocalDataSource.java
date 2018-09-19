package com.example.vladislav.myapplication.Support;

import android.content.SharedPreferences;
import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;

import javax.inject.Inject;

public class SettingsLocalDataSource implements SettingsDataSource {

    private static final String PREF_NAME = "prefs";
    private static final String TOKEN_KEY = "TOKEN";
    private static final String USER_ID_KEY = "USERID";
    private SharedPreferences preferences;


    @Inject
    public SettingsLocalDataSource(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void saveToken(String token) {
        preferences.edit().putString(TOKEN_KEY, token).apply();
    }

    @Override
    public String getToken() {
        return preferences.getString(TOKEN_KEY, null);
    }

    @Override
    public void saveUserId(String userId) {
        preferences.edit().putString(USER_ID_KEY, userId).apply();
    }

    @Override
    public String getUserId() {
        return preferences.getString(USER_ID_KEY, null);
    }
}
