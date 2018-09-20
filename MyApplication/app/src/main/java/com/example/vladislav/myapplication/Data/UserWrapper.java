package com.example.vladislav.myapplication.Data;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserWrapper {

    private String id;

    private User user;
    public UserWrapper() {
        // Default constructor required for calls to DataSnapshot.getValue(UserWrapper.class)
    }

    public UserWrapper(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}