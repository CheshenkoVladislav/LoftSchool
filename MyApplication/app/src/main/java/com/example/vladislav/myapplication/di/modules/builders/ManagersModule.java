package com.example.vladislav.myapplication.di.modules.builders;

import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.managers.RestManager;

import dagger.Module;

@Module
public class ManagersModule {

    RestManager provideRestManager(RealApiLoftSchool realApiLoftSchool) {
        return new RestManager(realApiLoftSchool);
    }
}
