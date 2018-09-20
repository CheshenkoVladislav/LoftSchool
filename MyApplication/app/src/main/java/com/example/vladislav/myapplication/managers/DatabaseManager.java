package com.example.vladislav.myapplication.managers;

import com.example.vladislav.myapplication.Data.User;
import com.example.vladislav.myapplication.Data.UserWrapper;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import javax.inject.Inject;

public class DatabaseManager {
    private final DatabaseReference database;

    @Inject
    public DatabaseManager(DatabaseReference database) {
        this.database = database;
    }

    public void createUser(FirebaseUser user) {
        database.child("users").child(user.getUid()).setValue("income");
        database.child("users").child(user.getUid()).setValue("outcome");
    }

    public void createUser(String userId, User user) {
        UserWrapper userWrapper = new UserWrapper(userId, user);
        database.child("users").setValue(userWrapper);
    }
}
