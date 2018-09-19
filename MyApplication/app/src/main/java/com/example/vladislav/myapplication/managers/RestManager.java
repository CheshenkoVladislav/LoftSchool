package com.example.vladislav.myapplication.managers;

import com.example.vladislav.myapplication.api.RealApiLoftSchool;

import javax.inject.Inject;

public class RestManager {

    private RealApiLoftSchool apiLoftSchool;

    @Inject
    public RestManager(RealApiLoftSchool apiLoftSchool) {
        this.apiLoftSchool = apiLoftSchool;
    }

}
