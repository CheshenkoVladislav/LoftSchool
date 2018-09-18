package com.example.vladislav.myapplication.di.component;

import com.example.vladislav.myapplication.app.App;
import com.example.vladislav.myapplication.di.modules.BasePresenterModule;
import com.example.vladislav.myapplication.di.modules.builders.MainModuleBuilder;
import com.example.vladislav.myapplication.di.modules.builders.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        MainModuleBuilder.class,
        NetworkModule.class,
        BasePresenterModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {

    void inject(App application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder app(App application);

        @BindsInstance
        Builder moduleNetwork(NetworkModule module);

        AppComponent build();
    }
}
