package com.example.vladislav.myapplication.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    Unbinder unbinder;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        bindViews();
    }

    @Override
    protected void onDestroy() {
        unbindViews();
        super.onDestroy();
    }

    private void bindViews() {
        unbinder = ButterKnife.bind(this);
    }

    private void unbindViews() {
        if (unbinder != null)
            unbinder.unbind();
    }

    public void initToolbar(Toolbar toolbar) {
        if (toolbar != null)
            setSupportActionBar(toolbar);
    }

    public void showFragment(String fragmentTag, Fragment fragment, int containerId, boolean addToBackStack) {
        if (getSupportFragmentManager() != null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            if (!isFinishing()) {
                ft.replace(containerId, fragment, fragmentTag);
                ft.show(fragment);
                if (addToBackStack)
                    ft.addToBackStack(null);
                ft.commit();
            }
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingFragmentInjector;
    }
}
