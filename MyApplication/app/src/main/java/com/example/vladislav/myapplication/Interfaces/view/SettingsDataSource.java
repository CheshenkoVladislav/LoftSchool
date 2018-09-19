package com.example.vladislav.myapplication.Interfaces.view;

public interface SettingsDataSource {
    void saveToken(String token);
    String getToken();
    void saveUserId(String userId);
    String getUserId();
}
