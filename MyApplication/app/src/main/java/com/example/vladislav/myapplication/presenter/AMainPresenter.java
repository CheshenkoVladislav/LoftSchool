package com.example.vladislav.myapplication.presenter;

import com.example.vladislav.myapplication.Interfaces.view.AMainMvpView;
import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;
import com.example.vladislav.myapplication.app.BasePresenter;

import io.reactivex.processors.BehaviorProcessor;

public class AMainPresenter extends BasePresenter<AMainMvpView> {

    private final SettingsDataSource settingsDataSource;

    public AMainPresenter(BehaviorProcessor<Boolean> eventProcessor, AMainMvpView view,
                          SettingsDataSource settingsDataSource) {
        super(eventProcessor, view);
        this.settingsDataSource = settingsDataSource;
    }

    @Override
    public void init() {
        if (view != null) {
            if (settingsDataSource.getUserId() == null)
                view.startSignInActivity();
            else
                view.initFragments();
        }
    }

    @Override
    protected void bindEvents() {

    }

}
